package com.example.csc179_patient_tracker_app.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;


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
    @ColumnInfo(name = "symptoms")
    public String symptoms;
    @ColumnInfo(name = "diagnosis")
    public String diagnosis;
    @ColumnInfo(name = "treatment_plan")
    public String treatmentPlan;

    @ColumnInfo(name = "lab_report")
    public String labReport;

    public AppointmentModel() {
    }

    public AppointmentModel(int patientId, String date, String appointmentTime, String reason) {
        this.patientId = patientId;
        this.date = date;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }

    protected AppointmentModel(Parcel in) {
        id = in.readInt();
        patientId = in.readInt();
        date = in.readString();
        appointmentTime = in.readString();
        reason = in.readString();
        symptoms = in.readString();
        diagnosis = in.readString();
        treatmentPlan = in.readString();
        labReport = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(patientId);
        dest.writeString(date);
        dest.writeString(appointmentTime);
        dest.writeString(reason);
        dest.writeString(symptoms);
        dest.writeString(diagnosis);
        dest.writeString(treatmentPlan);
        dest.writeString(labReport);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public PatientModel getPatient(MyAppDB db) {
        return db.PatientDAO().getPatient(patientId);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
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

    public String getLabReport() {
        return labReport;
    }

    public void setLabReport(String labReport) {
        this.labReport = labReport;
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
}
