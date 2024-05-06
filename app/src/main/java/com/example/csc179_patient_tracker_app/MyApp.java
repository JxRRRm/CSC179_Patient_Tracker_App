package com.example.csc179_patient_tracker_app;

import android.app.Application;
import androidx.room.Room;

import data.MyAppDB;

public class MyApp extends Application {

    private static MyAppDB databaseInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseInstance = Room.databaseBuilder(getApplicationContext(),
                        MyAppDB.class, "my_app_database")
                .build();
    }

    public static MyAppDB getDatabaseInstance() {
        return databaseInstance;
    }
}
