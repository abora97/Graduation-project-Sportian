package com.example.graduationprojectsportian.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.RecyclerView_Config;
import com.example.graduationprojectsportian.model.Sport;
import com.example.graduationprojectsportian.model.firebaseDatabaseHelper;
import com.example.graduationprojectsportian.util.Constants;

import java.util.ArrayList;
import java.util.List;



public class ClubsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    int searchDistance = 3, arrSize;
    List<Sport> sportList;
    double userLatitude, userLongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        recyclerView = findViewById(R.id.recyclerViewClubs);
        sportList = new ArrayList<Sport>();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            searchDistance = bundle.getInt(Constants.DISTANCE);
            userLatitude = bundle.getDouble(Constants.LATITUDE);
            userLongitude = bundle.getDouble(Constants.LONGITUDE);
            initFireBase();
        }
    }


    private void initFireBase() {
        new firebaseDatabaseHelper().readYouthCenters(new firebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Sport> sports, List<String> Keys) {

                initRec(sports, Keys);

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

    private void initRec(List<Sport> sports, List<String> keys) {
        if (searchDistance > sports.size()) {
            arrSize = sports.size();
        } else {
            arrSize = searchDistance;
        }

        for (int i = 0; i < arrSize; i++) {
            sportList.add(sports.get(i));
        }

        new RecyclerView_Config().setConfig(recyclerView, ClubsActivity.this, sportList, keys);
    }

}