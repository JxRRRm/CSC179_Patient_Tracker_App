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

import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.data.PatientModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class CreatePatientActivity extends AppCompatActivity {
    Button btn_register;
    EditText et_firstName, et_middleName, et_lastName, et_dob,  et_phone, et_email;
    MyAppDB db;
    private Calendar calendar;
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

        btn_register = findViewById(R.id.btn_submit);
        et_firstName = findViewById(R.id.et_firstName);
        et_middleName = findViewById(R.id.et_middleName);
        et_lastName = findViewById(R.id.et_lastName);
        et_dob =findViewById(R.id.et_dob);
        et_phone = findViewById(R.id.et_phonenumber);
        et_email = findViewById(R.id.et_medicalId);
        db = MyAppDB.getDbInstance(getApplicationContext());

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
                PatientModel patient;

                try {
                    patient = new PatientModel();
                    patient.firstName = et_firstName.getText().toString();
                    patient.middleName = et_middleName.getText().toString();
                    patient.lastName = et_lastName.getText().toString();
                    patient.dob = et_dob.getText().toString();
                    patient.mobilePhone = et_phone.getText().toString();
                    patient.email = et_email.getText().toString();
                    db.PatientDAO().insertPatient(patient);
                    Toast.makeText(CreatePatientActivity.this, "New patient registered!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                catch (Exception e){
                    Toast.makeText(CreatePatientActivity.this, "Error with patient Registration", Toast.LENGTH_SHORT).show();
                    //patientModel = new PatientModel(-1, "error", "error", "error", "error", "error", "error",false);
                }

                // dataBaseHelper = new DataBaseHelper(CreatePatientActivity.this);
                // boolean success = dataBaseHelper.addOne(patientModel);

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