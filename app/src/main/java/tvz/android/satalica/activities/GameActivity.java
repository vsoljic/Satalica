package tvz.android.satalica.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import tvz.android.satalica.R;
import tvz.android.satalica.view.ClockView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ClockView clockView = findViewById(R.id.clock);

        Button button1 = findViewById(R.id.answerOneBtn);
        Button button2 = findViewById(R.id.answerTwoBtn);
        Button button3 = findViewById(R.id.answerThreeBtn);
        Button button4 = findViewById(R.id.answerFourBtn);

        Random random = new Random();

        int hour = random.nextInt(12);
        int minutes = random.nextInt(60);
        clockView.setHour(hour);
        clockView.setMinute(minutes);

        List<String> times = new ArrayList<>();
        times.add(format(hour, minutes));
        times.add(format(random.nextInt(12), random.nextInt(60)));
        times.add(format(random.nextInt(12), random.nextInt(60)));
        times.add(format(random.nextInt(12), random.nextInt(60)));

        Collections.shuffle(times);

        button1.setText(times.get(0));
        button2.setText(times.get(1));
        button3.setText(times.get(2));
        button4.setText(times.get(3));
    }

    private String format(int hour, int minutes) {
        return String.format("%02d", hour) + ":" + String.format("%02d", minutes);
    }

    public void selectedAnswer(View view) {
        Button button = (Button) view;
        button.getText();
//        ....
    }


}
