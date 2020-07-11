package com.example.graduationprojectsportian.model;

import android.location.Location;

import java.util.ArrayList;

public class Filter {

    User user = new User();
    public ArrayList<Sport> flit(double mlatitude, double mlongitude, ArrayList<Sport> sports) {

        ArrayList<Sport> result = new ArrayList<>();


        for (int index = 0; index < sports.size(); index++) {

            Sport sport = sports.get(index);

//==================================================================================================

            Location locationA = new Location("point A");
            locationA.setLatitude(mlatitude);
            locationA.setLongitude(mlatitude);

            Location locationB = new Location("point B");
            locationB.setLatitude(user.Userlatitude);
            locationB.setLongitude(user.Userlongitude);

            double distance = locationA.distanceTo(locationB);


//==================================================================================================


            if (distance <= 1500){

                result.add(sport);
            }
        }
        return result;
    }


}