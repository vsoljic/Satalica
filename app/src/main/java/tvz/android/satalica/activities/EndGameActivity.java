package tvz.android.satalica.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import tvz.android.satalica.R;
import tvz.android.satalica.dao.AppDatabase;
import tvz.android.satalica.model.User;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Resources resources = getResources();
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int score = intent.getIntExtra("score", 0);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        User user = new User();
        user.setScore((long) score);
        user.setUsername(username);
        db.userDao().insertAll(user);

        String text = resources.getString(R.string.eg_text, username, score);

        TextView textView = findViewById(R.id.egTextView);
        textView.setText(text);

    }

    public void seeResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}
