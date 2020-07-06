package com.example.graduationprojectsportian.ui.activity.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.ScreenItem;
import com.example.graduationprojectsportian.ui.activity.HomeActivity;

import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IntroAppActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnBack, btnNext;

    private TextView[] mDots;
    LinearLayout linear;
    private int mCurrentPage;


    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_app);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        linear = findViewById(R.id.linear);

        //fill list
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Welcome", "  We are present in most of Egypt's youth centers in order to help you find the most suitable place to practice sports and the best cost ", R.drawable.firstintro));
        mList.add(new ScreenItem("Let's find out for yourself", " The application contains many services such as finding the nearest youth center" +
                " and news.", R.drawable.secondintro));


        //setup viewPager

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);


        addDotsIndicator(0);
        screenPager.addOnPageChangeListener(viewListener);


    }

    private void addDotsIndicator(int position) {
        mDots = new TextView[2];
        linear.removeAllViews(

        );
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            linear.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;
            if (position == 0) {
                btnNext.setEnabled(true);
                btnBack.setEnabled(false);
                btnBack.setVisibility(View.INVISIBLE);

                btnNext.setText("Next");
                btnBack.setText("");
            } else if (position == mDots.length - 1) {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);

                btnNext.setText("Finish");
                btnBack.setText("Back");
            } else {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);

                btnNext.setText("Next");
                btnBack.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (mCurrentPage == 1) {
                   // Toast.makeText(this, "om kalthom", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(IntroAppActivity.this, HomeActivity.class));
                }
                screenPager.setCurrentItem(mCurrentPage + 1);
                break;
            case R.id.btn_back:
                screenPager.setCurrentItem(mCurrentPage - 1);
               // Toast.makeText(this, "bead ank", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
