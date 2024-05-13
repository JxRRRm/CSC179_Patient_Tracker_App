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

import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.MyAppDB;

public class LabReportsActivity extends AppCompatActivity {
    private boolean editMode = false;
    private EditText labReport;
    private Button saveEditButton;
    private AppointmentModel appointmentModel;
    private MyAppDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_reports);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        appointmentModel = getIntent().getParcelableExtra("appointment_model");
        db = MyAppDB.getDbInstance(this);

        labReport = findViewById(R.id.lab_report_field);
        saveEditButton = findViewById(R.id.save_edit_button);

        labReport.setText(appointmentModel.getLabReport());

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

    public void saveToDatabase() {
        appointmentModel.setLabReport(labReport.getText().toString());

        db.AppointmentDAO().updateAppointment(appointmentModel);
    }

    public void readMode() {
        saveEditButton.setText("Edit");
        editMode = false;
        labReport.setFocusable(false);
        labReport.setFocusableInTouchMode(false);
        labReport.setClickable(false);
    }

    public void editMode() {
        saveEditButton.setText("Save");
        editMode = true;
        labReport.setFocusable(true);
        labReport.setFocusableInTouchMode(true);
        labReport.setClickable(true);
    }
}