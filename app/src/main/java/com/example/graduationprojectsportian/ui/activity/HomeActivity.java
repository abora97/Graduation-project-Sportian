package com.example.graduationprojectsportian.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.ui.fragment.ContactUs.GalleryFragment;
import com.example.graduationprojectsportian.ui.fragment.ExerciseFragment;
import com.example.graduationprojectsportian.ui.fragment.SportFragment;
import com.example.graduationprojectsportian.ui.fragment.aboutUs.SlideshowFragment;
import com.example.graduationprojectsportian.ui.fragment.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.layNews)
    LinearLayout layNews;
    @BindView(R.id.laySport)
    LinearLayout laySport;
    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("News");
         drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(this);

        layNews.setOnClickListener(this);
        laySport.setOnClickListener(this);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                openFragment(new HomeFragment(),"news");
                break;
            case R.id.nav_gallery:
                openFragment(new SlideshowFragment(),"about us");
                break;
            case R.id.nav_slideshow:
                openFragment(new GalleryFragment(),"contact us");
                break;
            case R.id.nav_exercise:
                openFragment(new ExerciseFragment(),"exercise");
                break;
        }
        //close navigation drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layNews:
                openFragment(new HomeFragment(),"news");
                break;
            case R.id.laySport:
                openFragment(new SportFragment(),"sport");
                break;
        }
    }

    private void openFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .replace(R.id.nav_host_fragment, fragment, tag)
            //    .add(R.id.nav_host_fragment,fragment, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }
}