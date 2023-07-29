package com.vvv.gymworkout;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SetGoalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_set_goal);

        ImageView back_button = findViewById(R.id.back_button);
        Spinner week_training = findViewById(R.id.week_training);
        Spinner first_day_of_week = findViewById(R.id.first_day_of_week);
        AppCompatButton save_goal_button = findViewById(R.id.save_goal_button);

        ArrayAdapter<CharSequence> weekTrainingAdapter = ArrayAdapter.createFromResource(
                this, R.array.weekly_training_days, android.R.layout.simple_spinner_item);
        weekTrainingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        week_training.setAdapter(weekTrainingAdapter);

        ArrayAdapter<CharSequence> firstDayOfWeekAdapter = ArrayAdapter.createFromResource(
                this, R.array.days_of_week, android.R.layout.simple_spinner_item);
        firstDayOfWeekAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        first_day_of_week.setAdapter(firstDayOfWeekAdapter);

        back_button.setOnClickListener(v -> finish());

        save_goal_button.setOnClickListener(v -> {
            String selectedWeekTraining = week_training.getSelectedItem().toString();
            String selectedFirstDayOfWeek = first_day_of_week.getSelectedItem().toString();

            String combinedValue = selectedWeekTraining + " - " + selectedFirstDayOfWeek;
            getIntent().putExtra("selected_goal", combinedValue);
            setResult(RESULT_OK, getIntent());
            finish();
        });
    }
}
