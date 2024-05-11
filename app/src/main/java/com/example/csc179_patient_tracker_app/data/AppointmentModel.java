package com.example.csc179_patient_tracker_app.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "Appointments")
public class AppointmentModel implements Comparable<AppointmentModel>, Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "patient_id")
    public int patientId;
    @ColumnInfo(name = "date_yyy/mm/dd")
    public String date;
    @ColumnInfo(name = "time")
    public String appointmentTime;
    @ColumnInfo(name = "reason")
    public String reason;
    @Ignore
    public PatientModel patient;
    // Constructor, getters, and setters can also be added if needed


    public AppointmentModel() {
    }
    public AppointmentModel(int patientId, String date, String appointmentTime, String reason) {
        this.patientId = patientId;
        this.date = date;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }

    protected AppointmentModel(Parcel in) {
        patient = in.readParcelable(PatientModel.class.getClassLoader());
        reason = in.readString();
        date = in.readString();
    }

    public static final Creator<AppointmentModel> CREATOR = new Creator<AppointmentModel>() {
        @Override
        public AppointmentModel createFromParcel(Parcel in) {
            return new AppointmentModel(in);
        }

        @Override
        public AppointmentModel[] newArray(int size) {
            return new AppointmentModel[size];
        }
    };

    public PatientModel getPatient() {
        return patient;
    }


    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", appointmentDate='" + date + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    @Override
    public int compareTo(AppointmentModel o) {
        // Compare String attributes, for example, a name or description
        // Assuming you have a String attribute called "name"
        return this.date.compareTo(o.date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(patient, flags);
        dest.writeString(reason);
        dest.writeString(date);
    }
}
