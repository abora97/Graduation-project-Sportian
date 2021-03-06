package com.example.graduationprojectsportian.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
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
    String sportSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        recyclerView = findViewById(R.id.recyclerViewClubs);
        sportList = new ArrayList<Sport>();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            searchDistance = bundle.getInt(Constants.DISTANCE);
            sportSearch = bundle.getString(Constants.SPORT);
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

//    private void initRec(List<Sport> sports, List<String> keys) {
//        if (searchDistance > sports.size()) {
//            arrSize = sports.size();
//        } else {
//            arrSize = searchDistance;
//        }
//
//        for (int i = 0; i < arrSize; i++) {
//            sportList.add(sports.get(i));
//        }
//
//        new RecyclerView_Config().setConfig(recyclerView, ClubsActivity.this, sportList, keys);
//    }

    private void initRec(List<Sport> sports, List<String> keys) {


        Location startPoint = new Location("locationA");


        Location endPoint = new Location("locationA");

        for (int i = 0; i < sports.size(); i++) {

            startPoint.setLatitude(userLatitude);
            startPoint.setLongitude(userLongitude);

            endPoint.setLatitude(sports.get(i).latitude);
            endPoint.setLongitude(sports.get(i).longitude);

            int distance = (int) startPoint.distanceTo(endPoint);

            if (distance <= searchDistance && sportSearch.equals(sports.get(i).sport)) {
                sportList.add(sports.get(i));
                Log.d("Fucking distance", distance + "  >>>>>  " + searchDistance);
            } else {
                Log.d("Fucking distance out", distance + "  >>>>>  " + searchDistance);
            }

        }

        new RecyclerView_Config().setConfig(recyclerView, ClubsActivity.this, sportList, keys);
    }
}