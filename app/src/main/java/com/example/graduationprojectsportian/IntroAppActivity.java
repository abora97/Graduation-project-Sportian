package com.example.graduationprojectsportian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IntroAppActivity extends AppCompatActivity {

    private ViewPager screenPager;
  IntroViewPagerAdapter introViewPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_app);

        //fill list
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("  unpopular sports","         In this application \n" +
                "youth can read the latest news\n" +
                "    about un popular sports  \n ",R.drawable.screen_start));
        mList.add(new ScreenItem("hello","     help youth to find the nearest place\n" +
                "   they want to play their sports through \n" +
                "     the youth sports clubs which follow \n" +
                "       the ministry of youth and sports \n",R.drawable.screen_sec));




        //setup viewPager

        screenPager =findViewById(R.id.screen_viewpager);
        introViewPagerAdapter=new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);





    }
}
