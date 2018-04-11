package tvz.android.satalica.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
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
    int hour = 0;
    int minutes = 0;
    String correctAnswer = null;

    Random random = new Random();
    ClockView clockView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    int gameSize;
    int current;
    int countCorrectAnswer = 0;
    String username = "";
    long startStopwatch = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        startStopwatch = System.currentTimeMillis();

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        gameSize = intent.getIntExtra("gameSize", 5);

        clockView = findViewById(R.id.clock);
        button1 = findViewById(R.id.answerOneBtn);
        button2 = findViewById(R.id.answerTwoBtn);
        button3 = findViewById(R.id.answerThreeBtn);
        button4 = findViewById(R.id.answerFourBtn);

        current = 0;

        setClock();
    }

    private void setClock() {
        hour = random.nextInt(12);
        minutes = random.nextInt(60);
        correctAnswer = String.format("%02d", hour) + ":" + String.format("%02d", minutes);

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

    public void checkSelectedAnswer(View view) {
        Button button = (Button) view;
        String answer = button.getText().toString();

        enableButtons(false);

        if (answer.equals(correctAnswer)) {
            button.setBackgroundResource(R.color.colorSuccess);
            countCorrectAnswer = countCorrectAnswer + 1;
        } else {
            button.setBackgroundColor(Color.RED);

            findCorrectAnswer(button1);
            findCorrectAnswer(button2);
            findCorrectAnswer(button3);
            findCorrectAnswer(button4);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++current <= gameSize) {
                    setClock();
                    decolorButtons();
                    enableButtons(true);
                } else {
                    long endStopwatch = System.currentTimeMillis();
                    long elapsedTime = (endStopwatch - startStopwatch) / 1000;

                    int countWrongAnswer = (gameSize - countCorrectAnswer);
                    long finalScore;

                    if (countWrongAnswer == 0) {
                        finalScore = elapsedTime + countCorrectAnswer;
                    } else {
                        finalScore = elapsedTime + countCorrectAnswer / countWrongAnswer;
                    }

                    Intent intent = new Intent(getApplicationContext(), EndGameActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("score", finalScore);
                    startActivity(intent);
                }
            }
        }, 3000);

    }

    private void findCorrectAnswer(Button button) {
        if (button.getText().equals(correctAnswer)) {
            button.setBackgroundResource(R.color.colorSuccess);
        }
    }

    private void enableButtons(boolean enabled) {
        button1.setEnabled(enabled);
        button2.setEnabled(enabled);
        button3.setEnabled(enabled);
        button4.setEnabled(enabled);
    }

    private void decolorButtons() {
        button1.setBackgroundResource(R.color.colorAccent);
        button2.setBackgroundResource(R.color.colorAccent);
        button3.setBackgroundResource(R.color.colorAccent);
        button4.setBackgroundResource(R.color.colorAccent);
    }

}
