package com.example.csc179_patient_tracker_app.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Medical_History",
        foreignKeys = @ForeignKey(entity = PatientModel.class,
                parentColumns = "id",
                childColumns = "patient_id",
                onDelete = ForeignKey.CASCADE))
public class MedicalHistoryModel {
    @PrimaryKey(autoGenerate = true)
    public int id; // Adjust data type if necessary
    @ColumnInfo(name = "patient_id")
    public int patientId;
    @ColumnInfo(name = "current_illnesses")
    public String currIllnesses;
    @ColumnInfo(name = "previous_illnesses")
    public String prevIllnesses;
    @ColumnInfo(name = "allergies")
    public String allergies;
    @ColumnInfo(name = "blood_group")
    public String bloodGroup;
    @ColumnInfo(name = "rh_factor")
    public String rhFactor;

    public MedicalHistoryModel() {
    }

    public MedicalHistoryModel(int id, int patientId, String currIllnesses, String prevIllnesses, String allergies, String bloodGroup, String rhFactor) {
        this.id = id;
        this.patientId = patientId;
        this.currIllnesses = currIllnesses;
        this.prevIllnesses = prevIllnesses;
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
        this.rhFactor = rhFactor;
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

    public String getCurrIllnesses() {
        return currIllnesses;
    }

    public void setCurrIllnesses(String currIllnesses) {
        this.currIllnesses = currIllnesses;
    }

    public String getPrevIllnesses() {
        return prevIllnesses;
    }

    public void setPrevIllnesses(String prevIllnesses) {
        this.prevIllnesses = prevIllnesses;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getRhFactor() {
        return rhFactor;
    }

    public void setRhFactor(String rhFactor) {
        this.rhFactor = rhFactor;
    }

    @Override
    public String toString() {
        return "MedicalHistoryModel{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", currIllnesses='" + currIllnesses + '\'' +
                ", prevIllnesses='" + prevIllnesses + '\'' +
                ", allergies='" + allergies + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", rhFactor='" + rhFactor + '\'' +
                '}';
    }
}
