package com.example.swebnb.ui.personal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PersonalViewModel(){
            mText = new MutableLiveData<>();
            mText.setValue(("This is Personal fragment"));
        }
        public LiveData<String> getText() {
            return mText;

    }
}
