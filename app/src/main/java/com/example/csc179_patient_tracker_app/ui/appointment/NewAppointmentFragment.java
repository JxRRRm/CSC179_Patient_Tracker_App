package com.example.csc179_patient_tracker_app.ui.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csc179_patient_tracker_app.appointmentdetails.AppointmentDetailsActivity;
import com.example.csc179_patient_tracker_app.CreatePatientActivity;
import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.databinding.FragmentCreateAnAppointmentBinding;

public class NewAppointmentFragment extends Fragment {

    private FragmentCreateAnAppointmentBinding binding;
    private Button newPatient;
    private Button scheduleAppointment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewAppointmentViewModel newAppointmentViewModel =
                new ViewModelProvider(this).get(NewAppointmentViewModel.class);

        binding = FragmentCreateAnAppointmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        newPatient = root.findViewById(R.id.new_patient_button);
        scheduleAppointment = root.findViewById(R.id.schedule_appointment_button);

        newPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAppointmentFragment.this.getContext(), CreatePatientActivity.class);
                startActivity(intent);
            }
        });

        scheduleAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewAppointmentFragment.this.getContext(), AppointmentDetailsActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}