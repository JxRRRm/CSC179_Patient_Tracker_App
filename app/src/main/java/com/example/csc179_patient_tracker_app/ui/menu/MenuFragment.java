package com.example.csc179_patient_tracker_app.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.PatientModel;
import com.example.csc179_patient_tracker_app.databinding.FragmentHomeBinding;
import com.example.csc179_patient_tracker_app.databinding.FragmentMenuBinding;
import com.example.csc179_patient_tracker_app.ui.home.HomeViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    private TextView ageText;
    private TextView nameText;
    private TextView genderText;

    private AppointmentModel appointment;
    private PatientModel patient;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        this.ageText = root.findViewById(R.id.age_text);
        this.nameText = root.findViewById(R.id.name_text);
        this.genderText = root.findViewById(R.id.gender_text);

        this.appointment = getArguments().getParcelable("appointment");
        this.patient = this.appointment.getPatient();

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.ageText.setText(String.format("Age: %d", ChronoUnit.YEARS.between(LocalDate.parse(patient.getDob(), parser), LocalDate.now())));
        this.nameText.setText(String.format("%s %s %s", patient.getFirstName(), patient.getMiddleName(), patient.getLastName()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}