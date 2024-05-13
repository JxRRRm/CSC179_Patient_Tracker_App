package com.example.csc179_patient_tracker_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.csc179_patient_tracker_app.data.AppointmentModel;

import java.util.List;


@Dao
public interface AppointmentDAO {

    @Query("SELECT * FROM Appointments")
    List<AppointmentModel> getAllAppointments();

    @Query("SELECT COUNT(*) FROM Appointments")
    int getAppointmentCount();

    @Update
    void updateAppointment(AppointmentModel appointmentModel);

    @Insert
    void insertAppointment(AppointmentModel... appointment);

    @Query("SELECT * FROM Appointments WHERE id = :id")
    AppointmentModel getAppointmentById(int id);

    // Query to retrieve patient's first, middle, and last name using patientId from AppointmentsTable
    @Query("SELECT p.first_name || ' ' || p.middle_name || ' ' || p.last_name " +
            "FROM Appointments AS a " +
            "INNER JOIN Patients AS p ON a.patient_id = p.id " +
            "WHERE a.patient_id = :patientId")
    String getPatientName(int patientId);

}

