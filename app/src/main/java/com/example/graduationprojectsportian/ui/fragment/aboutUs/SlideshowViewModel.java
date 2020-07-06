package com.example.graduationprojectsportian.ui.fragment.aboutUs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("We build this app to help you " +
                        "\n find Your favorite workout place " +
                        "\n in the nearest youth club with " +
                        "\njust one click");
    }

    public LiveData<String> getText() {
        return mText;
    }
}