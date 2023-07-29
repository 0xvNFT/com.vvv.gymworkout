package com.vvv.gymworkout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.vvv.gymworkout.workout1.Workout1Activity;
import com.vvv.gymworkout.workout2.Workout2Activity;
import com.vvv.gymworkout.workout3.Workout3Activity;
import com.vvv.gymworkout.workout4.Workout4Activity;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SET_GOAL = 1;
    private TextView goalOutput;
    private boolean isGoalSet = false;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        AppCompatButton set_goal_button = findViewById(R.id.set_goal_button);
        AppCompatButton arm_chest_button = findViewById(R.id.arm_chest_button);
        AppCompatButton abs_button = findViewById(R.id.abs_button);
        AppCompatButton shoulder_back_button = findViewById(R.id.shoulder_back_button);
        AppCompatButton legs_button = findViewById(R.id.legs_button);
        goalOutput = findViewById(R.id.goalOutput);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        if (sharedPreferences.contains("goal")) {
            isGoalSet = true;
            set_goal_button.setText("EDIT GOAL");
            goalOutput.setText(sharedPreferences.getString("goal", ""));
        } else {
            set_goal_button.setText("SET A GOAL");
        }
        set_goal_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SetGoalActivity.class);
            startActivityForResult(intent, REQUEST_SET_GOAL);
        });

        arm_chest_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Workout1Activity.class);
            startActivity(intent);
        });

        abs_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Workout2Activity.class);
            startActivity(intent);
        });

        shoulder_back_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Workout3Activity.class);
            startActivity(intent);
        });

        legs_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Workout4Activity.class);
            startActivity(intent);
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SET_GOAL && resultCode == RESULT_OK) {
            String selectedGoal = data.getStringExtra("selected_goal");

            goalOutput.setText(selectedGoal);

            isGoalSet = true;
            AppCompatButton set_goal_button = findViewById(R.id.set_goal_button);
            set_goal_button.setText("EDIT GOAL");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("goal", selectedGoal);
            editor.apply();
        }
    }
}