package com.example.csc179_patient_tracker_app.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.csc179_patient_tracker_app.data.MedicalHistoryModel;
@Dao
public interface MedicalHistoryDAO {
    @Insert
    void insertMedicalHistory(MedicalHistoryModel... medicalHistory);
    @Update
    void updateMedicalHistory(MedicalHistoryModel medicalHistory);
    @Delete
    void deleteMedicalHistory(MedicalHistoryModel medicalHistory);

    @Query("select * from Medical_History where id == :id ")
    public MedicalHistoryModel getMedicalHistory(int id);

}
