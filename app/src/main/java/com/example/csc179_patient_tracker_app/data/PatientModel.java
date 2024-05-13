package com.example.csc179_patient_tracker_app.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "Patients")
public class PatientModel implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id; // Adjust data type if necessary
    @ColumnInfo(name = "medical_id")
    public int medicalId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "middle_name")
    public String middleName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "dob")
    public String dob;
    @ColumnInfo(name = "home_number")
    public String homePhone;
    @ColumnInfo(name = "mobile_phone")
    public String mobilePhone;
    @ColumnInfo(name = "email_address")
    public String email;
    @ColumnInfo(name = "gender")
    public char gender;
    @ColumnInfo(name = "marital_status")
    public String maritalStatus;
    @ColumnInfo(name = "race/ethnicity")
    public String ethnicity;
    @ColumnInfo(name = "language")
    public String language;
    @ColumnInfo(name = "blood_group")
    public String bloodGroup;
    @ColumnInfo(name = "rh_factor")
    public String rhFactor;
    @ColumnInfo(name = "emergency_full_name")
    public String emergencyFullName;
    @ColumnInfo(name = "emergency_relation")
    public String emergencyRelation;
    @ColumnInfo(name = "emergency_phone_number")
    public String emergencyPhoneNumber;
    @ColumnInfo(name = "current_illnesses")
    public String currentIllnesses;
    @ColumnInfo(name = "previous_illnesses")
    public String previousIllnesses;
    @ColumnInfo(name = "specific_allergies")
    public String specificAllergies;
    @ColumnInfo(name = "current_medications")
    public String currentMedications;
    @ColumnInfo(name = "past_medications")
    public String pastMedications;
    @ColumnInfo(name = "doctor_visits")
    public String doctorVisits;
    @ColumnInfo(name = "vaccinations")
    public String vaccinations;

    // Constructor, getters, and setters can also be added if needed
    public PatientModel() {
    }

    public PatientModel(String firstName, String middleName, String lastName, String dob, String homePhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.homePhone = homePhone;
    }

    public PatientModel(int id, String firstName, String middleName, String lastName, String dob, String homePhone, String mobilePhone, String email, char gender, String maritalStatus, String ethnicity, String language, String bloodGroup, String rhFactor) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.ethnicity = ethnicity;
        this.language = language;
        this.bloodGroup = bloodGroup;
        this.rhFactor = rhFactor;
    }

    protected PatientModel(Parcel in) {
        id = in.readInt();
        medicalId = in.readInt();
        firstName = in.readString();
        middleName = in.readString();
        lastName = in.readString();
        dob = in.readString();
        homePhone = in.readString();
        mobilePhone = in.readString();
        email = in.readString();
        gender = (char) in.readInt();
        maritalStatus = in.readString();
        ethnicity = in.readString();
        language = in.readString();
        bloodGroup = in.readString();
        rhFactor = in.readString();
        emergencyFullName = in.readString();
        emergencyRelation = in.readString();
        emergencyPhoneNumber = in.readString();
        currentIllnesses = in.readString();
        previousIllnesses = in.readString();
        specificAllergies = in.readString();
        currentMedications = in.readString();
        pastMedications = in.readString();
        doctorVisits = in.readString();
        vaccinations = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(medicalId);
        dest.writeString(firstName);
        dest.writeString(middleName);
        dest.writeString(lastName);
        dest.writeString(dob);
        dest.writeString(homePhone);
        dest.writeString(mobilePhone);
        dest.writeString(email);
        dest.writeInt((int) gender);
        dest.writeString(maritalStatus);
        dest.writeString(ethnicity);
        dest.writeString(language);
        dest.writeString(bloodGroup);
        dest.writeString(rhFactor);
        dest.writeString(emergencyFullName);
        dest.writeString(emergencyRelation);
        dest.writeString(emergencyPhoneNumber);
        dest.writeString(currentIllnesses);
        dest.writeString(previousIllnesses);
        dest.writeString(specificAllergies);
        dest.writeString(currentMedications);
        dest.writeString(pastMedications);
        dest.writeString(doctorVisits);
        dest.writeString(vaccinations);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PatientModel> CREATOR = new Creator<PatientModel>() {
        @Override
        public PatientModel createFromParcel(Parcel in) {
            return new PatientModel(in);
        }

        @Override
        public PatientModel[] newArray(int size) {
            return new PatientModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public int getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(int medicalId) {
        this.medicalId = medicalId;
    }

    public String getEmergencyFullName() {
        return emergencyFullName;
    }

    public void setEmergencyFullName(String emergencyFullName) {
        this.emergencyFullName = emergencyFullName;
    }

    public String getEmergencyRelation() {
        return emergencyRelation;
    }

    public void setEmergencyRelation(String emergencyRelation) {
        this.emergencyRelation = emergencyRelation;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public String getCurrentIllnesses() {
        return currentIllnesses;
    }

    public void setCurrentIllnesses(String currentIllnesses) {
        this.currentIllnesses = currentIllnesses;
    }

    public String getPreviousIllnesses() {
        return previousIllnesses;
    }

    public void setPreviousIllnesses(String previousIllnesses) {
        this.previousIllnesses = previousIllnesses;
    }

    public String getSpecificAllergies() {
        return specificAllergies;
    }

    public void setSpecificAllergies(String specificAllergies) {
        this.specificAllergies = specificAllergies;
    }

    public String getCurrentMedications() {
        return currentMedications;
    }

    public void setCurrentMedications(String currentMedications) {
        this.currentMedications = currentMedications;
    }

    public String getPastMedications() {
        return pastMedications;
    }

    public void setPastMedications(String pastMedications) {
        this.pastMedications = pastMedications;
    }

    public String getDoctorVisits() {
        return doctorVisits;
    }

    public void setDoctorVisits(String doctorVisits) {
        this.doctorVisits = doctorVisits;
    }

    public String getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }
}

