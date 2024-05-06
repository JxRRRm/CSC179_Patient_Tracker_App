package com.example.csc179_patient_tracker_app;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import data.PatientDao;
import data.PatientModel;

public class CreatePatientActivity extends AppCompatActivity {
    Button btn_register;
    EditText et_firstName, et_middleName, et_lastName, et_dob,  et_phone, et_email;
    private Calendar calendar;
    PatientDao patientDao = MyApp.getDatabaseInstance().patientDao();
// Use patientDao to perform database operations...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_create_patient);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_register = findViewById(R.id.btn_register);
        et_firstName = findViewById(R.id.et_firstName);
        et_middleName = findViewById(R.id.et_middleName);
        et_lastName = findViewById(R.id.et_lastName);
        et_dob =findViewById(R.id.et_dob);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        calendar = Calendar.getInstance();

        // Disable keyboard input for et_dob
        et_dob.setInputType(InputType.TYPE_NULL);

// Prevent keyboard from showing up and show DatePickerDialog instead
        et_dob.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    showDatePickerDialog();
                    return true; // Consume touch event
                }
                return false;
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                PatientModel patient = new PatientModel();

                try {
                    // Convert the Editable object to a String
                    String dobText = et_dob.getText().toString();
                    // Create a SimpleDateFormat object to parse the date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    // Parse the String into a Date object
                    Date dob = dateFormat.parse(dobText);

                    patient.firstName = et_firstName.getText().toString();
                    patient.lastName = et_middleName.getText().toString();
                    patient.lastName = et_lastName.getText().toString();
                    patient.dob = dob;
                    patient.phone = et_phone.getText().toString();
                    patient.email = et_email.getText().toString();
                    patient.isNewPatient = true;
                    // Set other properties as needed...

                    PatientDao patientDao = MyApp.getDatabaseInstance().patientDao();
                    patientDao.insertPatient(patient);

                    Toast.makeText(CreatePatientActivity.this, patient.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(CreatePatientActivity.this, "!!", Toast.LENGTH_SHORT).show();
                    patient = new PatientModel(-1, "error", "error", "error", null, "error", "error",false);
                }

                Toast.makeText(CreatePatientActivity.this, "Patient Registered!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDateEditText();
        };

        new DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void updateDateEditText() {
        String dateFormat = "dd/MM/yyyy"; // Specify your date format here
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        et_dob.setText(sdf.format(calendar.getTime()));
    }
}