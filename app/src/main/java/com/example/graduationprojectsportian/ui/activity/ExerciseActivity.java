package com.example.graduationprojectsportian.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.ExerciseList;
import com.example.graduationprojectsportian.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

public class ExerciseActivity extends AppCompatActivity {
    @BindView(R.id.tvExercise)
    TextView tvExercise;
    @BindView(R.id.gifExercise)
    GifImageView gifExercise;
    private ExerciseList exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        ButterKnife.bind(this);
        // get data using bundle
        Bundle bundle = getIntent().getExtras();
        // check bundle
        if (bundle != null) {
            exercise = bundle.getParcelable(Constants.COUNTRY);
            setTitle(exercise.getExerciseName());
            init();
        }
    }

    private void init() {
        tvExercise.setText(exercise.getExerciseName());
        gifExercise.setImageResource(exercise.getExerciseImage());
    }
}