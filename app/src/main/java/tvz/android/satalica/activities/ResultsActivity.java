package tvz.android.satalica.activities;

import android.arch.persistence.room.Room;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import tvz.android.satalica.R;
import tvz.android.satalica.dao.AppDatabase;
import tvz.android.satalica.model.User;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        tableLayout.setStretchAllColumns(true);
        makeHeaderRow(tableLayout);
        populateRowData(tableLayout);

    }

    private void makeHeaderRow(TableLayout tableLayout) {
        TableRow tableRowHeader = new TableRow(this);
        tableRowHeader.setBackgroundColor(Color.parseColor("#886ab5"));
        tableRowHeader.setPadding(0, 35, 0, 35);
        tableRowHeader.setLayoutParams( new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT));

        TextView labelNumber = new TextView(this);
        makeTextView(labelNumber, "Redni broj", Color.WHITE, 20f);

        tableRowHeader.addView(labelNumber);

        TextView labelUsername = new TextView(this);
        makeTextView(labelUsername, "Korisničko ime", Color.WHITE, 20f);

        tableRowHeader.addView(labelUsername);

        TextView labelScore = new TextView(this);
        makeTextView(labelScore, "Bodovi", Color.WHITE, 20f);

        tableRowHeader.addView(labelScore);
        tableLayout.addView(tableRowHeader, new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private void makeTextView(TextView labelNumber, String text,int color, Float textSize) {
        labelNumber.setText(text);
        labelNumber.setTextColor(color);
        labelNumber.setPadding(0, 30, 0, 30);
        labelNumber.setGravity(Gravity.CENTER);
        labelNumber.setTextSize(textSize);
        labelNumber.setTypeface(labelNumber.getTypeface(), Typeface.BOLD);
    }

    private void populateRowData(TableLayout tableLayout) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        List<User> all = db.userDao().getAll();

        for (int i = 0; i < all.size(); i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams( new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT));

            TextView number = new TextView(this);
            makeTextView(number, Integer.toString(i+1), Color.parseColor("#886ab5"), 18f);
            tableRow.addView(number);

            TextView username = new TextView(this);
            makeTextView(username, all.get(i).getUsername(), Color.parseColor("#886ab5"), 18f);
            tableRow.addView(username);

            TextView score = new TextView(this);
            makeTextView(score, String.valueOf(all.get(i).getScore()), Color.parseColor("#886ab5"), 18f);
            tableRow.addView(score);

            tableRow.setBackgroundResource(R.drawable.border);
            tableLayout.addView(tableRow);
        }
    }
}
