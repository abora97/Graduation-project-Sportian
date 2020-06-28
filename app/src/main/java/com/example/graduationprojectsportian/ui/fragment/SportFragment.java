package com.example.graduationprojectsportian.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.ui.activity.ClubsActivity;

import butterknife.BindView;

public class SportFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    LinearLayout laySearch;
    Spinner spinnerSport;
    String[] sports;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_sport, container, false);

        spinnerSport = RootView.findViewById(R.id.spinnerSport);
        laySearch=RootView.findViewById(R.id.laySearch);

        init();
        // Inflate the layout for this fragment
        return RootView;
    }

    private void init() {
        
        laySearch.setOnClickListener(this);
         initSpinner();

    }

    private void initSpinner() {
        sports = new String[]{"fitness" , "Weightlifting" , "Gymnastics" , "Judo" ,"Taekwondo"
                , "Swimming" , "Basketball", "handball", "Volleyball" };

        spinnerSport.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sports);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerSport.setAdapter(aa);
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
        }
    }
}