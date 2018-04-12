package tvz.android.satalica.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tvz.android.satalica.R;

public class ChooseModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);
    }

    public void startCompetitiveMode(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("gameSize", 5);
        intent.putExtra("mode", "competitive");
        startActivity(intent);
    }

    public void startLearningMode(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("mode", "learning");
        startActivity(intent);
    }
}
