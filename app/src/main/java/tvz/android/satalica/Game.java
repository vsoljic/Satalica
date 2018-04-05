package tvz.android.satalica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Random;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TimePicker picker = findViewById(R.id.analogClock);
        picker.setEnabled(false);
        picker.setIs24HourView(true);
        picker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
        picker.setHour(12);
        picker.setMinute(45);

        Button button1 = findViewById(R.id.answerOneBtn);
        Button button2 = findViewById(R.id.answerTwoBtn);
        Button button3 = findViewById(R.id.answerThreeBtn);

        Random random = new Random();
        String hour = Integer.toString(random.nextInt(13));
        button1.setText(hour);
    }


}
