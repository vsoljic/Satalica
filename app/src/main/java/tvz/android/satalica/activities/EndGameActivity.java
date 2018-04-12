package tvz.android.satalica.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tvz.android.satalica.R;
import tvz.android.satalica.dao.AppDatabase;
import tvz.android.satalica.model.User;

public class EndGameActivity extends AppCompatActivity {

    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Resources resources = getResources();
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mode = intent.getStringExtra("mode");
        long score = intent.getLongExtra("score", 0L);
        String text;

        if (mode.equals("competitive")) {
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "satalica").allowMainThreadQueries().build();
            User user = new User();
            user.setScore(score);
            user.setUsername(username);
            db.userDao().insertAll(user);
            text = resources.getString(R.string.eg_text, username, score);
        } else {
            Button button = findViewById(R.id.egSeeResultsBtn);
            button.setText(getString(R.string.back_to_menu));
            String odgovori = String.format("%d/%d", intent.getIntExtra("countCorrectAnswer", 0), intent.getIntExtra("gameSize", 0));
            text = resources.getString(R.string.eg_text2, username, odgovori);
        }

        TextView textView = findViewById(R.id.egTextView);
        textView.setText(text);

    }

    public void seeResults(View view) {
        Intent intent;
        if (mode.equals("competitive")) {
            intent = new Intent(this, ResultsActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
    }
}
