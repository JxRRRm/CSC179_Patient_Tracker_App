package com.example.csc179_patient_tracker_app.data;

public class AppointmentWithPatientName {
    private String patientName;
    private AppointmentModel appointment;

    public AppointmentWithPatientName(String patientName, AppointmentModel appointment) {
        this.patientName = patientName;
        this.appointment = appointment;
    }

    public String getPatientName() {
        return patientName;
    }

    public AppointmentModel getAppointment() {
        return appointment;
    }
}
