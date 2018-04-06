package tvz.android.satalica.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tvz.android.satalica.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openUserPage(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        // Button button = findViewById(R.id.startGameBtn);
        startActivity(intent);
    }

    public void showResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}
