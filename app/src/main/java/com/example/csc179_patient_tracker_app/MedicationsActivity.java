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

public class MedicationsActivity extends AppCompatActivity {
    private boolean editMode = false;
    private EditText currentMedications;
    private EditText pastMedications;
    private Button saveEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medications);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        currentMedications = findViewById(R.id.current_medications_field);
        pastMedications = findViewById(R.id.past_medications_field);
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

    private void readMode() {
        saveEditButton.setText("Edit");
        editMode = false;
        currentMedications.setFocusable(false);
        pastMedications.setFocusable(false);
        currentMedications.setFocusableInTouchMode(false);
        pastMedications.setFocusableInTouchMode(false);
        currentMedications.setClickable(false);
        pastMedications.setClickable(false);
    }

    private void editMode() {
        saveEditButton.setText("Save");
        editMode = true;
        currentMedications.setFocusable(true);
        pastMedications.setFocusable(true);
        currentMedications.setFocusableInTouchMode(true);
        pastMedications.setFocusableInTouchMode(true);
        currentMedications.setClickable(true);
        pastMedications.setClickable(true);
    }
}