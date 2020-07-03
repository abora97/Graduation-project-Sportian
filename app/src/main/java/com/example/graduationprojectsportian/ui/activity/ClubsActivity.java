package com.example.graduationprojectsportian.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.RecyclerView_Config;
import com.example.graduationprojectsportian.model.Sport;
import com.example.graduationprojectsportian.model.firebaseDatabaseHelper;

import java.util.List;


public class ClubsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        mRecyclerView=findViewById(R.id.recyclerViewClubs);
        new firebaseDatabaseHelper().readYouthCenters(new firebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Sport> sports, List<String> Keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,ClubsActivity.this, sports, Keys);
            }

            @Override
            public void DataInserted() {

            }

            @Override
            public void DataUpdated() {

            }

            @Override
            public void DataDeleted() {

            }
        });
    }
}