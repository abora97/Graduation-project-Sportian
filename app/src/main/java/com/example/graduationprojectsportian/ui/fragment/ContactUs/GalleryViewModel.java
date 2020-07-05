package com.example.graduationprojectsportian.ui.fragment.ContactUs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("" +
//                "Email :SportianHTI@gmail.com \n"  +
//                "Phone Number : 01229216231");
    }

    public LiveData<String> getText() {
        return mText;
    }
}