package com.vvv.gymworkout.workout4;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vvv.gymworkout.R;
import com.vvv.gymworkout.workoutadapter.WorkoutAdapter;
import com.vvv.gymworkout.workoutmodel.WorkoutItem;

import java.util.ArrayList;
import java.util.List;

public class Workout4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_workout4);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        RecyclerView recyclerView1 = findViewById(R.id.workout1_recycler_view);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        List<WorkoutItem> workout1List = new ArrayList<>();
        workout1List.add(new WorkoutItem(4, R.drawable.lvl1, "Level 1", "Light Intensity"));
        workout1List.add(new WorkoutItem(4, R.drawable.lvl2, "Level 2", "Light Intensity"));
        workout1List.add(new WorkoutItem(4, R.drawable.lvl3, "Level 3", "Light Intensity"));
        workout1List.add(new WorkoutItem(4, R.drawable.lvl4, "Level 4", "Light Intensity"));
        workout1List.add(new WorkoutItem(4, R.drawable.lvl5, "Level 5", "Light Intensity"));
        workout1List.add(new WorkoutItem(4, R.drawable.lvl6, "Level 6", "Light Intensity"));
        workout1List.add(new WorkoutItem(4, R.drawable.lvl7, "Level 7", "Light Intensity"));

        WorkoutAdapter adapter = new WorkoutAdapter(workout1List, this);
        recyclerView1.setAdapter(adapter);
    }
}
