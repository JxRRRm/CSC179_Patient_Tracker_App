// MenuFragment.java
package com.example.csc179_patient_tracker_app.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.csc179_patient_tracker_app.AnalysisPageActivity;
import com.example.csc179_patient_tracker_app.GeneralPatientInformationActivity;
import com.example.csc179_patient_tracker_app.HealthConditionsActivity;
import com.example.csc179_patient_tracker_app.LabReportsActivity;
import com.example.csc179_patient_tracker_app.MedicationsActivity;
import com.example.csc179_patient_tracker_app.UpcomingAppointmentsActivity;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.PatientModel;
import com.example.csc179_patient_tracker_app.databinding.FragmentMenuBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    private TextView ageText;
    private TextView nameText;
    private AppointmentModel appointment;
    private PatientModel patient;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate using View Binding
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Assign TextViews using View Binding
        ageText = binding.ageText;
        nameText = binding.nameText;

        // Retrieve appointment from arguments
        appointment = getArguments().getParcelable("appointment");
        if (appointment != null) {
            patient = appointment.getPatient();

            DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dob = LocalDate.parse(patient.getDob(), parser);
            long age = ChronoUnit.YEARS.between(dob, LocalDate.now());

            ageText.setText(String.format("Age: %d", age));
            nameText.setText(String.format("%s %s %s", patient.getFirstName(), patient.getMiddleName(), patient.getLastName()));
        }

        // Set click listener for the "General Patient Information" button
        binding.buttonGeneralPatientInfo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), GeneralPatientInformationActivity.class);
            startActivity(intent);
        });

        // Set click listener for the "Health Conditions" button
        binding.buttonHealthCondition.setOnClickListener(v -> {
            // Replace with your desired activity or fragment
            Intent intent = new Intent(getActivity(), HealthConditionsActivity.class); // Example activity
            startActivity(intent);
        });

        // Set click listener for the "Health Conditions" button
        binding.buttonMedications.setOnClickListener(v -> {
            // Replace with your desired activity or fragment
            Intent intent = new Intent(getActivity(), MedicationsActivity.class); // Example activity
            startActivity(intent);
        });
        // Set click listener for the "Health Conditions" button
        binding.buttonAnalysis.setOnClickListener(v -> {
            // Replace with your desired activity or fragment
            Intent intent = new Intent(getActivity(), AnalysisPageActivity.class); // Example activity
            startActivity(intent);
        });
        // Set click listener for the "Health Conditions" button
        binding.buttonLabReports.setOnClickListener(v -> {
            // Replace with your desired activity or fragment
            Intent intent = new Intent(getActivity(), LabReportsActivity.class); // Example activity
            startActivity(intent);
        });

        // Set click listener for the "Health Conditions" button
        binding.buttonUpcomingAppointments.setOnClickListener(v -> {
            // Replace with your desired activity or fragment
            Intent intent = new Intent(getActivity(), UpcomingAppointmentsActivity.class); // Example activity
            startActivity(intent);
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
