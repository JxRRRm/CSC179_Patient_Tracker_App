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
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "middle_name")
    public String middleName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "dob_YYYY/MM/DD")
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

    // Constructor, getters, and setters can also be added if needed
    public PatientModel() {
    }

    public PatientModel(String firstName, String middleName, String lastName, String dob, String mobilePhone, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.mobilePhone = mobilePhone;
        this.email = email;
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
        firstName = in.readString();
        middleName = in.readString();
        lastName = in.readString();
        dob = in.readString();
        mobilePhone = in.readString();
        email = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(firstName);
        dest.writeString(middleName);
        dest.writeString(lastName);
        dest.writeString(dob);
        dest.writeString(mobilePhone);
        dest.writeString(email);
    }
    
}
