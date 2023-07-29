package com.vvv.gymworkout.workoutlevels;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vvv.gymworkout.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level6);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        RecyclerView recyclerView1Content = findViewById(R.id.workout1_content_recycler_view);
        recyclerView1Content.setLayoutManager(new LinearLayoutManager(this));

        List<LevelItem> workout1ContentList = new ArrayList<>();
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_1, "JUMPING JACKS", "01:00"));
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_2, "INCLINE PUSH-UPS", "01:00"));
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_3, "BOX PUSH-UPS", "01:00"));
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_4, "INCLINE PUSH-UPS", "01:00"));
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_5, "KNEE PUSH-UPS", "01:00"));
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_6, "SHOULDER STRETCH", "01:00"));
        workout1ContentList.add(new LevelItem(6, R.drawable.gym_7, "COBRA STRETCH", "01:00"));

        Collections.shuffle(workout1ContentList);

        LevelAdapter adapter = new LevelAdapter(workout1ContentList, this);
        recyclerView1Content.setAdapter(adapter);
    }
}
