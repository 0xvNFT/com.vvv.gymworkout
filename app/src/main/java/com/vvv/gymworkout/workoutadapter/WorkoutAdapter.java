package com.vvv.gymworkout.workoutadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vvv.gymworkout.R;
import com.vvv.gymworkout.workoutlevels.Level1Activity;
import com.vvv.gymworkout.workoutlevels.Level2Activity;
import com.vvv.gymworkout.workoutlevels.Level3Activity;
import com.vvv.gymworkout.workoutlevels.Level4Activity;
import com.vvv.gymworkout.workoutlevels.Level5Activity;
import com.vvv.gymworkout.workoutlevels.Level6Activity;
import com.vvv.gymworkout.workoutlevels.Level7Activity;
import com.vvv.gymworkout.workoutmodel.WorkoutItem;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.Workout1ViewHolder> {

    private final List<WorkoutItem> workout1List;
    private final Context context;

    public WorkoutAdapter(List<WorkoutItem> workout1List, Context context) {
        this.workout1List = workout1List;
        this.context = context;
    }

    @NonNull
    @Override
    public Workout1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout_1, parent, false);
        return new Workout1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Workout1ViewHolder holder, int position) {
        WorkoutItem item = workout1List.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewOnly.setText(item.getTextOnly());

        holder.cardView.setOnClickListener(v -> {
            int clickedPosition = holder.getAdapterPosition();

            if (clickedPosition == 0) {
                Intent intent = new Intent(context, Level1Activity.class);
                context.startActivity(intent);
            } else if (clickedPosition == 1) {
                Intent intent = new Intent(context, Level2Activity.class);
                context.startActivity(intent);
            } else if (clickedPosition == 2) {
                Intent intent = new Intent(context, Level3Activity.class);
                context.startActivity(intent);
            } else if (clickedPosition == 3) {
                Intent intent = new Intent(context, Level4Activity.class);
                context.startActivity(intent);
            } else if (clickedPosition == 4) {
                Intent intent = new Intent(context, Level5Activity.class);
                context.startActivity(intent);
            } else if (clickedPosition == 5) {
                Intent intent = new Intent(context, Level6Activity.class);
                context.startActivity(intent);
            } else if (clickedPosition == 6) {
                Intent intent = new Intent(context, Level7Activity.class);
                context.startActivity(intent);
            }

        });
    }


    @Override
    public int getItemCount() {
        return workout1List.size();
    }

    public static class Workout1ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewOnly;
        CardView cardView;

        public Workout1ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.levels);
            textViewTitle = itemView.findViewById(R.id.titleView1);
            textViewOnly = itemView.findViewById(R.id.textViewOnly1);
            cardView = itemView.findViewById(R.id.cardView1);
        }
    }
}


