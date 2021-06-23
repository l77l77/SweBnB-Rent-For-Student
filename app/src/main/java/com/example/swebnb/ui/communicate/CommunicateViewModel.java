package com.example.swebnb.ui.communicate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommunicateViewModel extends  ViewModel {
    private  MutableLiveData<String> mText;

    public  CommunicateViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue(("This is communicate fragment"));
    }
    public LiveData<String> getText() {
        return mText;
    }
}

