package tvz.android.satalica.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

import tvz.android.satalica.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openChooseModePage(View view) {
        Intent intent = new Intent(this, ChooseModeActivity.class);
        startActivity(intent);
    }

    public void showResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void startTutorial(View view) {
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    public void setLocale(View view) {
        String language;
        switch (view.getId()) {
            case (R.id.hr):
                language = "hr";
                break;
            default:
                language = "en";
                break;
        }
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;

        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        recreate();
    }
}
