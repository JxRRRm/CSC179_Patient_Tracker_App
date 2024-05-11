package com.example.csc179_patient_tracker_app.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.csc179_patient_tracker_app.data.EmergencyContactModel;


@Dao
public interface EmergencyContactDAO {
    @Insert
    void insertEmergencyContact(EmergencyContactModel... emergencyContact);
    @Update
    void updateContactInfo(EmergencyContactModel emergencyContact);
    @Delete
    void deleteContactInfo(EmergencyContactModel emergencyContact);

    @Query("select * from Emergency_Contact where id == :id ")
    public EmergencyContactModel getContact(int id);

    @Query("SELECT COUNT(*) FROM Emergency_Contact")
    int getContactCount();
}
