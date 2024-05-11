package com.example.csc179_patient_tracker_app.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Emergency_Contact",
        foreignKeys = @ForeignKey(entity = PatientModel.class,
                parentColumns = "id",
                childColumns = "patient_id",
                onDelete = ForeignKey.CASCADE))
public class EmergencyContactModel {
    @PrimaryKey(autoGenerate = true)
    public int id; // Adjust data type if necessary
    @ColumnInfo(name = "patient_id")
    public int patientId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "phone_number")
    public String phone_number;

    public EmergencyContactModel(int patientId, String firstName, String lastName, String phone_number) {
        this.patientId = patientId;
        this.firstName = firstName;

        this.lastName = lastName;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
