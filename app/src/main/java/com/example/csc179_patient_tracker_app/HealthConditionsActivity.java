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

import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.data.PatientModel;

public class HealthConditionsActivity extends AppCompatActivity {
    private boolean editMode = false;

    private EditText currentIllnesses;
    private EditText previousIllnesses;
    private EditText specificAllergies;
    private Button saveEditButton;
    private PatientModel patientModel;
    private MyAppDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_healthconditions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = MyAppDB.getDbInstance(this);
        this.patientModel = getIntent().getParcelableExtra("patient_model");

        currentIllnesses = findViewById(R.id.current_illnesses_field);
        previousIllnesses = findViewById(R.id.previous_illnesses_field);
        specificAllergies = findViewById(R.id.specific_allergies_field);
        saveEditButton = findViewById(R.id.save_edit_button);

        currentIllnesses.setText(patientModel.getCurrentIllnesses());
        previousIllnesses.setText(patientModel.getPreviousIllnesses());
        specificAllergies.setText(patientModel.getSpecificAllergies());

        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMode) {
                    readMode();
                    saveToDatabase();
                } else {
                    editMode();
                }
            }
        });

        readMode();
    }

    private void saveToDatabase() {
        patientModel.setCurrentIllnesses(currentIllnesses.getText().toString());
        patientModel.setPreviousIllnesses(previousIllnesses.getText().toString());
        patientModel.setSpecificAllergies(specificAllergies.getText().toString());

        db.PatientDAO().updatePatient(patientModel);
    }

    private void readMode() {
        saveEditButton.setText("Edit");
        editMode = false;
        currentIllnesses.setFocusable(false);
        previousIllnesses.setFocusable(false);
        specificAllergies.setFocusable(false);
        currentIllnesses.setFocusableInTouchMode(false);
        previousIllnesses.setFocusableInTouchMode(false);
        specificAllergies.setFocusableInTouchMode(false);
        currentIllnesses.setClickable(false);
        previousIllnesses.setClickable(false);
        specificAllergies.setClickable(false);
    }

    private void editMode() {
        saveEditButton.setText("Save");
        editMode = true;
        currentIllnesses.setFocusable(true);
        previousIllnesses.setFocusable(true);
        specificAllergies.setFocusable(true);
        currentIllnesses.setFocusableInTouchMode(true);
        previousIllnesses.setFocusableInTouchMode(true);
        specificAllergies.setFocusableInTouchMode(true);
        currentIllnesses.setClickable(true);
        previousIllnesses.setClickable(true);
        specificAllergies.setClickable(true);
    }
}