package com.example.csc179_patient_tracker_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adapters.PatientAdapter;
import data.MyAppDB;
import data.PatientDao;
import data.PatientModel;
import view_models.PatientViewModel;

public class PatientLookUpActivity extends AppCompatActivity {
    private Button btn_search;
    private EditText et_firstName, et_middleName, et_lastName, et_dob,  et_phone, et_email;
    private RecyclerView rv_patientList;
    private PatientAdapter adapter;
    private PatientViewModel patientViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_lookup_patient);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_search = findViewById(R.id.btn_search);
        et_firstName = findViewById(R.id.et_firstName);
        et_middleName = findViewById(R.id.et_middleName);
        et_lastName = findViewById(R.id.et_lastName);
        et_dob = findViewById(R.id.et_dob);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        rv_patientList = findViewById(R.id.rv_patientlist);

        rv_patientList.setLayoutManager(new LinearLayoutManager(this));

        // Get an instance of the Room database
        PatientDao patientDao = MyApp.getDatabaseInstance().patientDao();

        // Get the ViewModel
        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);

        // Observe the LiveData
        patientViewModel.getAllPatients().observe(this, new Observer<List<PatientModel>>() {
            @Override
            public void onChanged(List<PatientModel> patients) {
                // Update the UI
                adapter = new PatientAdapter(PatientLookUpActivity.this, patients);
                rv_patientList.setAdapter(adapter);
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    };

}
