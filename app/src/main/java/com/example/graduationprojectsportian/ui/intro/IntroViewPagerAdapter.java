package com.example.graduationprojectsportian.ui.intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.model.ScreenItem;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {

Context mContext;
List<ScreenItem> mListScreem;

    public IntroViewPagerAdapter(Context mContext, List<ScreenItem> mListScreem) {
        this.mContext = mContext;
        this.mListScreem = mListScreem;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen =inflater.inflate(R.layout.layout_screen,null);
        ImageView imageSlide= layoutScreen.findViewById(R.id.intro_img);
        TextView titel = layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.intro_description);
        titel.setText(mListScreem.get(position).getTitel());
        description.setText(mListScreem.get(position).getDescription());
        imageSlide.setImageResource(mListScreem.get(position).getScreenItem());

          container.addView(layoutScreen);
            return layoutScreen;


    }

    @Override
    public int getCount() {
        return mListScreem.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return  view == o ;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }

}
