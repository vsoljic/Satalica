package tvz.android.satalica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tvz.android.satalica.R;

public class UserActivity extends AppCompatActivity {
    String gameSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String mode = intent.getStringExtra("mode");

        if ("competitive".matches(mode)) {
            TextView labelGameSize = findViewById(R.id.labelGameSize);
            EditText inputGameSize = findViewById(R.id.inputGameSize);

            labelGameSize.setVisibility(View.INVISIBLE);
            inputGameSize.setVisibility(View.INVISIBLE);

            gameSize = Integer.toString(intent.getIntExtra("gameSize", 5));
        }


    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        EditText inputFieldUsername = findViewById(R.id.inputUserName);
        String username = inputFieldUsername.getText().toString();

        if (gameSize.isEmpty() || gameSize.matches("")) {
            EditText inputFieldGameSize = findViewById(R.id.inputGameSize);
            gameSize = inputFieldGameSize.getText().toString();
        }

        if (username.matches("")) {
            Toast toast = Toast.makeText(this, "Nisi unio korisničko ime! :(", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        } else if (gameSize.equals("")) {
            Toast toast = Toast.makeText(this, "Nisi unio broj zadataka! :(", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }

        intent.putExtra("username", username);
        intent.putExtra("gameSize", Integer.parseInt(gameSize));
        startActivity(intent);
    }
}
