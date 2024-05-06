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
    private final PatientModel bob = new PatientModel(0, "Bob", "", "Smith", "12/25/1995", "123-456-7890", "bob@example.com", true);
    private final PatientModel alice = new PatientModel(1, "Alice", "", "Smith", "02/29/1975", "333-333-3333", "alice@example.com", false);
    private final PatientModel john = new PatientModel(2, "John", "", "Doe", "01/31/1987", "777-777-7777", "john@example.com", true);

    private final List<AppointmentModel> appointments = new ArrayList<>();

    {
        appointments.add(new AppointmentModel(bob, "Annual checkup", LocalDate.of(2024, 5, 23).toEpochDay()));
        appointments.add(new AppointmentModel(alice, "Vaccination", LocalDate.of(2024, 6, 12).toEpochDay()));
        appointments.add(new AppointmentModel(john, "Cough", LocalDate.of(2024, 5, 20).toEpochDay()));
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