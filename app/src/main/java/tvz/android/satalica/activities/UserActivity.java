package tvz.android.satalica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import tvz.android.satalica.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        EditText inputField = findViewById(R.id.inputUserName);
        String username = inputField.getText().toString();

        if (username.matches("")) {
            Toast toast = Toast.makeText(this, "Nisi unio korisničko ime! :(", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }

        intent.putExtra("username", username);
        startActivity(intent);
    }
}
