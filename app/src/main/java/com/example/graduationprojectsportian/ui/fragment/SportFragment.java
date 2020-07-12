package com.example.graduationprojectsportian.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.User;
import com.example.graduationprojectsportian.ui.activity.ClubsActivity;
import com.example.graduationprojectsportian.ui.activity.MapsActivity;
import com.example.graduationprojectsportian.util.Constants;

import butterknife.BindView;

import static com.example.graduationprojectsportian.util.Constants.REQUEST_GET_MAP_LOCATION;

public class SportFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    LinearLayout laySearch, laySport, layLocation;
    Spinner spinnerSport, spinnerDistance;
    String[] sports;
    String[] distance;
    int searchDistance = 5;
    String sportItem, distanceItem;
    double userLatitude = 0, userLongitude = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_sport, container, false);

        spinnerSport = RootView.findViewById(R.id.spinnerSport);
        spinnerDistance = RootView.findViewById(R.id.spinnerDistance);
        laySearch = RootView.findViewById(R.id.laySearch);
        laySport = RootView.findViewById(R.id.laySport);
        layLocation = RootView.findViewById(R.id.layLocation);

        layLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivityForResult(new Intent(getActivity(), MapsActivity.class), REQUEST_GET_MAP_LOCATION);
                // startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });


        init();
        // Inflate the layout for this fragment
        return RootView;
    }


    private void init() {

        laySearch.setOnClickListener(this);
        laySport.setOnClickListener(this);
        initSpinner();

    }


    private void initSpinner() {
        //spinnerSport
        sports = new String[]{"Aerobics", "Weightlifting", "Gymnastics", "Judo", "Taekwondo"
                , "Swimming", "Basketball", "handball", "Volleyball"};

        ArrayAdapter arrSports = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sports);
        arrSports.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerSport.setAdapter(arrSports);
        spinnerSport.setOnItemSelectedListener(this);


        //spinnerDistance
        distance = new String[]{"5", "10", "25", "50", "100","200"};
        ArrayAdapter arrdistance = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, distance);
        arrdistance.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerDistance.setAdapter(arrdistance);
        spinnerDistance.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.laySearch:
                if (userLatitude == 0 && userLongitude == 0) {
                    Toast.makeText(getContext(), "Please add your location", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), ClubsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.DISTANCE, searchDistance);
                    bundle.putString(Constants.SPORT, sportItem);
                    bundle.putDouble(Constants.LATITUDE, userLatitude);
                    bundle.putDouble(Constants.LONGITUDE, userLongitude);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.laySport:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerSport) {
            sportItem = spinnerSport.getItemAtPosition(position).toString();

        } else if (parent.getId() == R.id.spinnerDistance) {
            distanceItem = spinnerDistance.getItemAtPosition(position).toString();
            switch (position) {
                case 0:
                    searchDistance = 5000;
                    break;
                case 1:
                    searchDistance = 10000;
                    break;
                case 2:
                    searchDistance = 25000;
                    break;
                case 3:
                    searchDistance = 50000;
                    break;
                case 4:
                    searchDistance = 100000;
                    break;
                case 5:
                    searchDistance = 200000;
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //    Toast.makeText(getContext(), resultCode + ">>>>>>>>" + requestCode, Toast.LENGTH_SHORT).show();
        if (requestCode == REQUEST_GET_MAP_LOCATION && resultCode == REQUEST_GET_MAP_LOCATION) {

            userLatitude = data.getDoubleExtra(Constants.LATITUDE, 0);
            userLongitude = data.getDoubleExtra(Constants.LONGITUDE, 0);
        }

    }


}