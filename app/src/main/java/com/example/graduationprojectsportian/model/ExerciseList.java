package com.example.graduationprojectsportian.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ExerciseList implements Parcelable {
    private int exerciseImage;
    private String exerciseName;


    public ExerciseList(int exerciseImage, String exerciseName) {
        this.exerciseImage = exerciseImage;
        this.exerciseName = exerciseName;
    }

    protected ExerciseList(Parcel in) {
        exerciseImage = in.readInt();
        exerciseName = in.readString();
    }

    public static final Creator<ExerciseList> CREATOR = new Creator<ExerciseList>() {
        @Override
        public ExerciseList createFromParcel(Parcel in) {
            return new ExerciseList(in);
        }

        @Override
        public ExerciseList[] newArray(int size) {
            return new ExerciseList[size];
        }
    };

    public int getExerciseImage() {
        return exerciseImage;
    }

    public void setExerciseImage(int exerciseImage) {
        this.exerciseImage = exerciseImage;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(exerciseImage);
        dest.writeString(exerciseName);
    }
}
