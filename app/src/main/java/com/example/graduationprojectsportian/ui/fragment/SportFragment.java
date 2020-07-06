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

import androidx.fragment.app.Fragment;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.ui.activity.ClubsActivity;
import com.example.graduationprojectsportian.ui.activity.MapsActivity;

import butterknife.BindView;

public class SportFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    LinearLayout laySearch, laySport, layLocation;
    Spinner spinnerSport, spinnerDistance;
    String[] sports;
    String[] distance;
    int searchDistance = 5;

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
                startActivity(new Intent(getActivity(), MapsActivity.class));
                ;
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

        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sports);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerSport.setAdapter(aa);


        //spinnerDistance
        distance = new String[]{"5", "10", "25", "50"};
        ArrayAdapter dd = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, distance);
        dd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerDistance.setAdapter(dd);
        spinnerDistance.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.laySearch:
                Intent intent = new Intent(getActivity(), ClubsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("distance", searchDistance);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.laySport:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                searchDistance =3;
                break;
            case 1:
                searchDistance = 5;
                break;
            case 2:
                searchDistance = 7;
                break;
            case 3:
                searchDistance = 15;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}