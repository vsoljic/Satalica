package tvz.android.satalica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, Game.class);
        EditText inputField = findViewById(R.id.inputUserName);
        String username = inputField.getText().toString();
        intent.putExtra("username", username);
        startActivity(intent);
    }
}
