package tvz.android.satalica.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

import tvz.android.satalica.R;

public class TutorialActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView timeTextView;
    String randomTime;
    int tutorialSize;
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        timeTextView = findViewById(R.id.timeTextView);
        randomTime = "";
        tutorialSize = 5;
        setTimeLabel();
    }

    public void checkIfTimeIsCorrect(View view) {
        enableButton(false);
        int selectedHour = timePicker.getHour();
        int selectedMinutes = timePicker.getMinute();

        String selectedTime = String.format(String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinutes));

        LayoutInflater inflater = getLayoutInflater();

        if (selectedTime.equals(randomTime)) {
            showToast(inflater, R.layout.activity_popup_success);

        } else {
            showToast(inflater, R.layout.activity_popup_failure);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++current < tutorialSize) {
                    setTimeLabel();
                    resetTimePicker();
                    enableButton(true);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndTutorialActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);

    }

    private void showToast(LayoutInflater inflater, int activity_popup) {
        View layout = inflater.inflate(activity_popup, null);
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    private void setTimeLabel() {
        Random random = new Random();
        int hour = random.nextInt(12);
        int minutes = random.nextInt(60);

        randomTime = String.format("%02d", hour) + ":" + String.format("%02d", minutes);
        timeTextView.setText(randomTime);
    }

    private void resetTimePicker() {
        timePicker.setMinute(0);
        timePicker.setHour(0);
        timePicker.refreshDrawableState();
    }

    private void enableButton(boolean enabled) {
        Button button = findViewById(R.id.checkTimeBtn);
        button.setEnabled(enabled);
    }

}
