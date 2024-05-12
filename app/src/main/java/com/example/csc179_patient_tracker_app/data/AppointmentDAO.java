package com.example.csc179_patient_tracker_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.csc179_patient_tracker_app.data.AppointmentModel;

import java.util.List;


@Dao
public interface AppointmentDAO {
    @Query("SELECT * FROM Appointments")
    List<AppointmentModel> getAllAppointments();
    @Query("SELECT COUNT(*) FROM Appointments")
    int getAppointmentCount();

    @Insert
    void insertAppointment(AppointmentModel... appointment);
}

