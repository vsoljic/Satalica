package tvz.android.satalica.activities;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tvz.android.satalica.R;

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
        labelNumber.setText("Redni broj");
        labelNumber.setTextColor(Color.WHITE);
        labelNumber.setPadding(0, 30, 0, 30);
        labelNumber.setGravity(Gravity.CENTER);
        labelNumber.setTextSize(20f);
        labelNumber.setTypeface(labelNumber.getTypeface(), Typeface.BOLD);

        tableRowHeader.addView(labelNumber);

        TextView labelUsername = new TextView(this);
        labelUsername.setText("Korisničko ime");
        labelUsername.setTextColor(Color.WHITE);
        labelUsername.setPadding(0, 30, 0, 30);
        labelUsername.setGravity(Gravity.CENTER);
        labelUsername.setTextSize(20f);
        labelUsername.setTypeface(labelUsername.getTypeface(), Typeface.BOLD);

        tableRowHeader.addView(labelUsername);

        TextView labelScore = new TextView(this);
        labelScore.setText("Bodovi");
        labelScore.setTextColor(Color.WHITE);
        labelScore.setPadding(0, 30, 0, 30);
        labelScore.setGravity(Gravity.CENTER);
        labelScore.setTextSize(20f);
        labelScore.setTypeface(labelScore.getTypeface(), Typeface.BOLD);

        tableRowHeader.addView(labelScore);
        tableLayout.addView(tableRowHeader, new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private void populateRowData(TableLayout tableLayout) {
        for(int i = 0; i < 10; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams( new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT));

            TextView number = new TextView(this);
            number.setText(Integer.toString(i+1));
            number.setTextColor(Color.parseColor("#886ab5"));
            number.setPadding(40, 40, 40, 40);
            number.setGravity(Gravity.CENTER);
            number.setTextSize(18f);
            number.setTypeface(number.getTypeface(), Typeface.BOLD);
            tableRow.addView(number);

            TextView username = new TextView(this);
            username.setText("Vedrana"+i);
            username.setTextColor(Color.parseColor("#886ab5"));
            username.setPadding(40, 40, 40, 40);
            username.setGravity(Gravity.CENTER);
            username.setTypeface(username.getTypeface(), Typeface.BOLD);
            username.setTextSize(18f);

            tableRow.addView(username);

            TextView score = new TextView(this);
            score.setText(Integer.toString(10+i));
            score.setTextColor(Color.parseColor("#886ab5"));
            score.setPadding(40, 40, 40, 40);
            score.setGravity(Gravity.CENTER);
            score.setTypeface(score.getTypeface(), Typeface.BOLD);
            score.setTextSize(18f);

            tableRow.addView(score);
            tableRow.setBackgroundResource(R.drawable.border);
            tableLayout.addView(tableRow);
        }
    }
}
