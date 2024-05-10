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

public class AnalysisPageActivity extends AppCompatActivity {
    private boolean editMode = false;
    private EditText symptoms;
    private EditText diagnosis;
    private EditText treatmentPlan;
    private Button saveEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_analysis_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        symptoms = findViewById(R.id.symptoms_field);
        diagnosis = findViewById(R.id.diagnosis_field);
        treatmentPlan = findViewById(R.id.treatment_plan_field);
        saveEditButton = findViewById(R.id.save_edit_button);

        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMode) {
                    readMode();
                } else {
                    editMode();
                }
            }
        });

        readMode();
    }

    public void editMode() {
        saveEditButton.setText("Save");
        editMode = true;
        symptoms.setFocusable(true);
        diagnosis.setFocusable(true);
        treatmentPlan.setFocusable(true);
        symptoms.setFocusableInTouchMode(true);
        diagnosis.setFocusableInTouchMode(true);
        treatmentPlan.setFocusableInTouchMode(true);
        symptoms.setClickable(true);
        diagnosis.setClickable(true);
        treatmentPlan.setClickable(true);
    }

    public void readMode() {
        saveEditButton.setText("Edit");
        editMode = false;
        symptoms.setFocusable(false);
        diagnosis.setFocusable(false);
        treatmentPlan.setFocusable(false);
        symptoms.setFocusableInTouchMode(false);
        diagnosis.setFocusableInTouchMode(false);
        treatmentPlan.setFocusableInTouchMode(false);
        symptoms.setClickable(false);
        diagnosis.setClickable(false);
        treatmentPlan.setClickable(false);
    }
}