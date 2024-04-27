package com.example.csc179_patient_tracker_app.ui.lookup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.csc179_patient_tracker_app.databinding.FragmentLookupPatientBinding;

public class LookupPatient extends Fragment {

    private FragmentLookupPatientBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLookupPatientBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}