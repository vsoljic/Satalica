package tvz.android.satalica.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Random;

import tvz.android.satalica.R;

public class TutorialActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView timeTextView;
    String randomTime;
    int tutorialSize;
    PopupWindow popupWindow;
    View popupView;


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
        int selectedHour = timePicker.getHour();
        int selectedMinutes = timePicker.getMinute();

        String selectedTime = String.format(String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinutes));

        if (selectedTime.equals(randomTime)) {

            popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            popupView = getLayoutInflater().inflate(R.layout.activity_popup, null);
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        } else {

        }


       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++current <= tutorialSize) {
                    setTimeLabel();
                    resetTimePicker();
                } else {
                    //finish game
                }
            }
        }, 3000);*/

    }

    private void setTimeLabel() {
        Random random = new Random();
        int hour = random.nextInt(12);
        int minutes = random.nextInt(60);

        randomTime = String.format("%02d", hour) + ":" + String.format("%02d", minutes);
        timeTextView.setText(randomTime);

    }

    private void resetTimePicker() {
        timePicker.setHour(0);
        timePicker.setMinute(0);
    }

    public void cancelPopup(View view) {
        popupWindow.dismiss();
    }
}
