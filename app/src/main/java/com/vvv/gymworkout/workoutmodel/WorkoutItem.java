package com.vvv.gymworkout.workoutmodel;

public class WorkoutItem {
    private final int imageResId;
    private final String title;
    private final String textOnly;
    private final int type;

    public WorkoutItem(int type, int imageResId, String title, String textOnly) {
        this.type = type;
        this.imageResId = imageResId;
        this.title = title;
        this.textOnly = textOnly;
    }

    public int getType() {
        return type;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getTextOnly() {
        return textOnly;
    }
}
