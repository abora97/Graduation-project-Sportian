package com.example.graduationprojectsportian.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.ExerciseList;
import com.example.graduationprojectsportian.ui.fragment.home.AdapterNews;

import java.util.ArrayList;
import java.util.List;


public class ExerciseFragment extends Fragment implements View.OnClickListener {

    LinearLayout layExercise;
    RecyclerView recExercise;
    private RecyclerView.LayoutManager mLayoutManager;
    AdapterExercise mAdapter;
    List<ExerciseList> exerciseList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        layExercise = view.findViewById(R.id.layExercise);
        recExercise = view.findViewById(R.id.recExercise);

        layExercise.setOnClickListener(this);

        initRecycle();
        return view;
    }

    private void initRecycle() {
        mAdapter = new AdapterExercise(getContext());
        recExercise.setLayoutManager(getLayoutManager());
        recExercise.setAdapter(mAdapter);

        getData();
        mAdapter.setList(exerciseList);
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        if (mLayoutManager == null) {
            mLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        return mLayoutManager;
    }

    void getData() {
        exerciseList = new ArrayList<>();
        exerciseList.add(new ExerciseList(R.drawable.jumping_jacks, "Exercise 1\nJumping Jacks"));
        exerciseList.add(new ExerciseList(R.drawable.wall_site, "Exercise 2\nWall Site"));
        exerciseList.add(new ExerciseList(R.drawable.push_up, "Exercise 3\nPush Up"));
        exerciseList.add(new ExerciseList(R.drawable.abdominal_crunch, "Exercise 4\nAbdominal Crunch"));
        exerciseList.add(new ExerciseList(R.drawable.step_up_into_chair, "Exercise 5\nStep Up into Chair"));
        exerciseList.add(new ExerciseList(R.drawable.squat, "Exercise 6\n Squat"));
        exerciseList.add(new ExerciseList(R.drawable.triceps_dip_on_chair, "Exercise 7\nTriceps Dip on Chair"));
        exerciseList.add(new ExerciseList(R.drawable.plank , "Exercise 8\nPlank "));
        exerciseList.add(new ExerciseList(R.drawable.high_knees_running_in_place, "Exercise 9\nhigh Knees Running\nIn place"));
        exerciseList.add(new ExerciseList(R.drawable.lunge, "Exercise10\n Lunge"));
        exerciseList.add(new ExerciseList(R.drawable.push_up_and_rotation, "Exercise 11\nPush Up and Rotation"));
        exerciseList.add(new ExerciseList(R.drawable.side_plank, "Exercise 12\nSide Plank"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layExercise:

                break;
        }
    }
}