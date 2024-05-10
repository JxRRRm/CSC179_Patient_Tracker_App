package com.example.csc179_patient_tracker_app.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.PatientModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends ViewModel {
    private final PatientModel bob = new PatientModel( "Bob", "", "Smith", "12/25/1995", "123-456-7890", "bob@example.com");
    private final PatientModel alice = new PatientModel("Alice", "", "Smith", "02/29/1975", "333-333-3333", "alice@example.com");
    private final PatientModel john = new PatientModel("John", "", "Doe", "01/31/1987", "777-777-7777", "john@example.com");

    private final List<AppointmentModel> appointments = new ArrayList<>();

    {
        appointments.add(new AppointmentModel(1,"2024/5/23", "07:00","Annual checkup"));
        appointments.add(new AppointmentModel(2,"2024/6/12", "13:00", "Vaccination"));
        appointments.add(new AppointmentModel(3, "2024/5/20", "21:00","Cough"));
    }

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public List<AppointmentModel> getAppointments() {
        return appointments;
    }
}