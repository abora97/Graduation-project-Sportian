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

public class SportFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    LinearLayout laySearch,laySport,layLocation;
    Spinner spinnerSport, spinnerDistance;
    String[] sports;
    int[] distance;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_sport, container, false);

        spinnerSport = RootView.findViewById(R.id.spinnerSport);
        spinnerDistance = RootView.findViewById(R.id.spinnerDistance);
        laySearch = RootView.findViewById(R.id.laySearch);
        laySport=RootView.findViewById(R.id.laySport);
        layLocation=RootView.findViewById(R.id.layLocation);

        layLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapsActivity.class));;
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
        sports = new String[]{"fitness" , "Weightlifting" , "Gymnastics" , "Judo" ,"Taekwondo"
                , "Swimming" , "Basketball", "handball", "Volleyball" };
        spinnerSport.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sports);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerSport.setAdapter(aa);


        //spinnerDistance
        distance = new int[]{5,10,25,50};
        spinnerDistance.setOnItemSelectedListener(this);
        ArrayAdapter dd = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sports);
        dd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerSport.setAdapter(dd);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //  Toast.makeText(getContext(), sports[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.laySearch:
                startActivity(new Intent(getActivity(), ClubsActivity.class));
                break;
            case R.id.laySport:
                break;
        }
    }
}