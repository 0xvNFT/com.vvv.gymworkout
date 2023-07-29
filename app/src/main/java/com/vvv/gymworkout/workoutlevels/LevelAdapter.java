package com.vvv.gymworkout.workoutlevels;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vvv.gymworkout.R;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.Workout1ContentViewHolder> {

    private final List<LevelItem> workout1ContentList;
    private final Context context;
    private CountDownTimer countDownTimer;

    public LevelAdapter(List<LevelItem> workout1ContentList, Context context) {
        this.workout1ContentList = workout1ContentList;
        this.context = context;
    }

    @NonNull
    @Override
    public Workout1ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout_1_content, parent, false);
        return new Workout1ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Workout1ContentViewHolder holder, int position) {
        LevelItem item = workout1ContentList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewOnly.setText(item.getTextOnly());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownTimer == null) {
                    startCountdown(holder);
                } else {
                    stopCountdown();
                    holder.countdownTimerTextView.setVisibility(View.GONE);
                    holder.countdownTimer.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return workout1ContentList.size();
    }

    private void startCountdown(Workout1ContentViewHolder holder) {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        long millisInFuture = 30000;
        long countDownInterval = 1000;

        countDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                holder.countdownTimerTextView.setText(String.valueOf(seconds));
                holder.textViewTitle.setVisibility(View.GONE);
                holder.textViewOnly.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                holder.textViewTitle.setVisibility(View.VISIBLE);
                holder.textViewOnly.setVisibility(View.VISIBLE);
                holder.countdownTimerTextView.setVisibility(View.GONE);
                holder.countdownTimer.setVisibility(View.GONE);
            }
        };

        countDownTimer.start();

        holder.countdownTimerTextView.setVisibility(View.VISIBLE);
        holder.countdownTimer.setVisibility(View.VISIBLE);
    }

    private void stopCountdown() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    public static class Workout1ContentViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewOnly;
        CardView cardView;
        ProgressBar countdownTimer;
        TextView countdownTimerTextView;

        public Workout1ContentViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gymImage);
            textViewTitle = itemView.findViewById(R.id.contentTitle);
            textViewOnly = itemView.findViewById(R.id.textViewOnlyContent);
            cardView = itemView.findViewById(R.id.cardViewContent1);
            countdownTimer = itemView.findViewById(R.id.countdownTimer);
            countdownTimerTextView = itemView.findViewById(R.id.countdownTimerTextView);
        }
    }

}

