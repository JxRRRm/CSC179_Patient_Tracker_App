package com.example.csc179_patient_tracker_app.ui.appointment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewAppointmentViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NewAppointmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is new appointment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}