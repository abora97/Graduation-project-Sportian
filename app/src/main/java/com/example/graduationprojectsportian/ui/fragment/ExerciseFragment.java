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
        exerciseList.add(new ExerciseList(R.drawable.exxx, "ss"));
        exerciseList.add(new ExerciseList(R.drawable.ic_sport, "qq"));
        exerciseList.add(new ExerciseList(R.drawable.ic_sport, "we"));
        exerciseList.add(new ExerciseList(R.drawable.exxx, "qwq"));
//       exerciseList.add(new ExerciseList("ss","sqwqs"));
//       exerciseList.add(new ExerciseList("ss","sqws"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layExercise:

                break;
        }
    }
}