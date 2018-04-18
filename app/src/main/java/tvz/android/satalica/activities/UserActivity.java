package tvz.android.satalica.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import tvz.android.satalica.R;

public class UserActivity extends AppCompatActivity {
    String gameSize;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");

        LinearLayout linearLayout = findViewById(R.id.usernamelinearLayout);

        if ("competitive".matches(mode)) {
            TextView labelGameSize = findViewById(R.id.labelGameSize);
            EditText inputGameSize = findViewById(R.id.inputGameSize);

            linearLayout.removeView(labelGameSize);
            linearLayout.removeView(inputGameSize);

            gameSize = Integer.toString(intent.getIntExtra("gameSize", 5));
        } else {
            TextView labelUsername = findViewById(R.id.labelUserName);
            EditText inputUsername = findViewById(R.id.inputUserName);

            linearLayout.removeView(labelUsername);
            linearLayout.removeView(inputUsername);
        }

        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        linearLayout.setLayoutParams(layoutParams);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);

        if (mode.equals("competitive")) {
            EditText inputFieldUsername = findViewById(R.id.inputUserName);
            String username = inputFieldUsername.getText().toString();

            if (username.matches("")) {
                Toast toast = Toast.makeText(this, "Nisi unio korisničko ime! :(", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            intent.putExtra("username", username);
        }

        if (gameSize == null) {
            EditText inputFieldGameSize = findViewById(R.id.inputGameSize);
            gameSize = inputFieldGameSize.getText().toString();
            if (gameSize.equals("")) {
                Toast toast = Toast.makeText(this, "Nisi unio broj zadataka! :(", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
        }

        intent.putExtra("gameSize", Integer.parseInt(gameSize));
        intent.putExtra("mode", mode);
        startActivity(intent);
        finish();
    }
}
