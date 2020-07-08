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
        exerciseList.add(new ExerciseList(R.drawable.jumping_jacks, "Ex1  Jumping Jacks"));
        exerciseList.add(new ExerciseList(R.drawable.wall_site, "Ex2  Wall Site"));
        exerciseList.add(new ExerciseList(R.drawable.push_up, "Ex3  Push Up"));
        exerciseList.add(new ExerciseList(R.drawable.abdominal_crunch, "Ex4 Abdominal Crunch"));
        exerciseList.add(new ExerciseList(R.drawable.step_up_into_chair, "Ex5 Step Up into Chair"));
        exerciseList.add(new ExerciseList(R.drawable.squat, "Ex6 Squat.gif"));
        exerciseList.add(new ExerciseList(R.drawable.triceps_dip_on_chair, "Ex7 Triceps Dip on Chair"));
        exerciseList.add(new ExerciseList(R.drawable.plank , "EX8 Plank "));
        exerciseList.add(new ExerciseList(R.drawable.high_knees_running_in_place, "Ex9 high Knees  Running In place"));
        exerciseList.add(new ExerciseList(R.drawable.lunge, "Ex10 Lunge"));
        exerciseList.add(new ExerciseList(R.drawable.push_up_and_rotation, "Ex11 Push Up and Rotation"));
        exerciseList.add(new ExerciseList(R.drawable.side_plank, "Ex12 Side Plank"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layExercise:

                break;
        }
    }
}