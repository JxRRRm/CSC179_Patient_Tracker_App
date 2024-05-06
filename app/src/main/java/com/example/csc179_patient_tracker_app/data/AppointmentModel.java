package com.example.csc179_patient_tracker_app.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AppointmentModel implements Comparable<AppointmentModel>, Parcelable {
    private PatientModel patient;
    private String reason;
    private long date;

    public AppointmentModel(PatientModel patient, String reason, long date) {
        this.patient = patient;
        this.reason = reason;
        this.date = date;
    }

    public AppointmentModel() {
    }

    protected AppointmentModel(Parcel in) {
        patient = in.readParcelable(PatientModel.class.getClassLoader());
        reason = in.readString();
        date = in.readLong();
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

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public int compareTo(AppointmentModel o) {
        long d = this.date - o.date;
        if(d < 0) return -1;
        if(d > 0) return 1;

        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(patient, flags);
        dest.writeString(reason);
        dest.writeLong(date);
    }
}


