package com.example.graduationprojectsportian.ui.activity;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.graduationprojectsportian.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location CurrentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQEST_CODE =101;
    double Curlongitude;
    double Curlatitude;
    LatLng position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();

        MapFragment mapFragment = (MapFragment)getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(Curlatitude, Curlongitude);
        // View current location position and move the camera
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14f));

        //add marker
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng nlatLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(nlatLng);
                markerOptions.title("My Click");
                googleMap.clear();
                markerOptions.draggable(true);
                googleMap.addMarker(markerOptions);
                Toast.makeText(getApplicationContext(),"Location "+nlatLng,Toast.LENGTH_LONG).show();
            }
        });


        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                position = marker.getPosition();
            }
        });

    }



    // Link Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //Change Style Map
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Change the map type based on the user's selection.
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }//End Change Style Map

    //Zoom Buttons
    public void onZoom(View view) {
        if (view.getId() == R.id.zoomInbtn){
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if (view.getId() == R.id.zoomOutbtn){
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }

    }//End Zoom buttons


    //Check Permission
    private void fetchLastLocation() {
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION )
                != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[]
                    {android.Manifest.permission.ACCESS_COARSE_LOCATION}, REQEST_CODE);
        }

        //Get Current Location
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null) {
                    CurrentLocation = location;
                    Curlatitude = CurrentLocation.getLatitude();
                    Curlongitude = CurrentLocation.getLongitude();
                    Toast.makeText(getApplicationContext(),Curlatitude+" " +Curlongitude,Toast.LENGTH_LONG).show();

                    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                    MapFragment mapFragment = (MapFragment)getFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLastLocation();
                }
                break;
        }
    }


    // Show current location
    public void oncurrent(View view) {
        LatLng latLng = new LatLng(Curlatitude, Curlongitude);
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("You are Here !");
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f));
        mMap.addMarker(markerOptions);
        Toast.makeText(getApplicationContext(),"Location "+latLng,Toast.LENGTH_LONG).show();
    }
}

