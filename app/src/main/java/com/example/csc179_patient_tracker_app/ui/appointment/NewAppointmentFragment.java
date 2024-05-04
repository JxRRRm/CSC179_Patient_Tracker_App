package com.example.csc179_patient_tracker_app.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csc179_patient_tracker_app.databinding.FragmentNewAppointmentBinding;

public class NewAppointmentFragment extends Fragment {

    private FragmentNewAppointmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewAppointmentViewModel newAppointmentViewModel =
                new ViewModelProvider(this).get(NewAppointmentViewModel.class);

        binding = FragmentNewAppointmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        newAppointmentViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}