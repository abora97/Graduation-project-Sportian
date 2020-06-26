package com.example.graduationprojectsportian.ui.fragment.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("We build this app to help you find Your favorite workout place in nearest youth club with just one click");
    }

    public LiveData<String> getText() {
        return mText;
    }
}