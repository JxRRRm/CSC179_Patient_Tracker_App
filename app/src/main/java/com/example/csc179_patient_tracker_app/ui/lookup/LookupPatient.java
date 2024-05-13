package com.example.csc179_patient_tracker_app.ui.lookup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.databinding.FragmentLookupPatientBinding;
import com.example.csc179_patient_tracker_app.util.PatientSearchRecyclerAdapter;

public class LookupPatient extends Fragment {

    private FragmentLookupPatientBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLookupPatientBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView patientsRecycler = root.findViewById(R.id.patients_recycler);
        patientsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        PatientSearchRecyclerAdapter patientSearchRecyclerAdapter = new PatientSearchRecyclerAdapter(getContext(), (patientModel -> {}));
        patientsRecycler.setAdapter(patientSearchRecyclerAdapter);

        EditText firstName = root.findViewById(R.id.et_firstName);
        EditText middleName = root.findViewById(R.id.et_middleName);
        EditText lastName = root.findViewById(R.id.et_lastName);
        EditText dob = root.findViewById(R.id.et_dob);
        EditText medicalId = root.findViewById(R.id.et_medicalid);

        Button searchButton = root.findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!firstName.getText().toString().isEmpty() || !middleName.getText().toString().isEmpty() || !lastName.getText().toString().isEmpty()) {
                    patientSearchRecyclerAdapter.search(firstName.getText().toString(), middleName.getText().toString(), lastName.getText().toString(), dob.getText().toString(), medicalId.getText().toString());
                } else {
                    patientSearchRecyclerAdapter.resetSearch();
                }
            }
        });

        return root;
    }
}