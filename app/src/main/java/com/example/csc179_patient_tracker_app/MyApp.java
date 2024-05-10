package com.example.csc179_patient_tracker_app;

import android.app.Application;

import com.example.csc179_patient_tracker_app.data.MyAppDB;


public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the database
        MyAppDB.getDbInstance(this);
    }
}
