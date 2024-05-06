package com.example.csc179_patient_tracker_app.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.databinding.FragmentNewAppointmentBinding;

public class NewAppointmentFragment extends Fragment {

    private FragmentNewAppointmentBinding binding;
    private NavController navController;
    private Button newPatientButton, searchPatientButton;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewAppointmentViewModel newAppointmentViewModel =
                new ViewModelProvider(this).get(NewAppointmentViewModel.class);

        binding = FragmentNewAppointmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        navController = NavHostFragment.findNavController(this);
        newPatientButton = root.findViewById(R.id.btn_new_patient);
        searchPatientButton = root.findViewById(R.id.btn_search);
        searchPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_navigation_new_appointment_to_search_patient);
            }
        });
        newPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_navigation_new_appointment_to_create_patient);
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