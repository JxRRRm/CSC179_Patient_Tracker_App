package com.example.csc179_patient_tracker_app.appointmentdetails;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.util.PatientSearchRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppointmentDetailsActivity extends AppCompatActivity {
    private Button btn_submit;
    private EditText et_dob, et_firstName, et_lastName, et_middleName, et_phonenumber, et_reason, et_date, et_time;
    private RecyclerView patientsRecycler;
    private PatientSearchRecyclerAdapter patientSearchRecyclerAdapter;
    private EditText time;
    private MyAppDB db;
    private Calendar calendar;

    private class SearchTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            runOnUiThread(() -> {
                runSearch();
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointmentdetails);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_submit = findViewById(R.id.btn_submit);
        et_firstName = findViewById(R.id.et_firstName);
        et_middleName = findViewById(R.id.et_middleName);
        et_lastName = findViewById(R.id.et_lastName);
        et_dob = findViewById(R.id.et_dob);
        et_phonenumber = findViewById(R.id.et_phonenumber);
        et_reason = findViewById(R.id.et_reason);
        et_date = findViewById(R.id.et_date);
        et_time = findViewById(R.id.et_time);
        patientsRecycler = findViewById(R.id.patients_recycler);
        db = MyAppDB.getDbInstance(getApplicationContext());

        patientSearchRecyclerAdapter = new PatientSearchRecyclerAdapter(this, (patientModel -> {
            et_firstName.setText(patientModel.firstName);
            et_lastName.setText(patientModel.lastName);
            et_middleName.setText(patientModel.middleName);
            et_dob.setText(patientModel.dob);
            et_phonenumber.setText(patientModel.homePhone);
        }));
        patientsRecycler.setLayoutManager(new LinearLayoutManager(this));
        patientsRecycler.setAdapter(patientSearchRecyclerAdapter);
        runSearch();

        et_firstName.addTextChangedListener(new SearchTextWatcher());
        et_middleName.addTextChangedListener(new SearchTextWatcher());
        et_lastName.addTextChangedListener(new SearchTextWatcher());
        et_dob.addTextChangedListener(new SearchTextWatcher());
        et_phonenumber.addTextChangedListener(new SearchTextWatcher());

        calendar = Calendar.getInstance();

        // Disable keyboard input for et_dob
        et_dob.setInputType(InputType.TYPE_NULL);
        et_date.setInputType(InputType.TYPE_NULL);
        et_time.setInputType(InputType.TYPE_NULL);
        // Prevent keyboard from showing up and show DatePickerDialog instead
        et_dob.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    showDatePickerDialog(et_dob);
                    return true; // Consume touch event
                }
                return false;
            }
        });
        et_date.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    showDatePickerDialog(et_date);
                    return true; // Consume touch event
                }
                return false;
            }
        });

        et_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
        et_time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    et_time.setInputType(InputType.TYPE_CLASS_DATETIME); // Show keyboard for datetime input
                } else {
                    et_time.setInputType(InputType.TYPE_NULL); // Hide keyboard
                }
            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Retrieve patient ID using provided details
                    int patientId = db.PatientDAO().getPatientIdByDetails(
                            et_firstName.getText().toString(),
                            et_middleName.getText().toString(),
                            et_lastName.getText().toString(),
                            et_dob.getText().toString(),
                            et_phonenumber.getText().toString()
                    );

                    if(patientId == 0) {
                        throw new IllegalArgumentException("Patient not found!");
                    }

                    // If patient ID is valid, create a new appointment
                    if (patientId != -1) {
                        AppointmentModel appointment = new AppointmentModel();
                        appointment.patientId = patientId;
                        appointment.reason = et_reason.getText().toString();
                        appointment.date = et_date.getText().toString();
                        appointment.appointmentTime = et_time.getText().toString();

                        // Insert appointment into the database
                        db.AppointmentDAO().insertAppointment(appointment);

                        // Display success message
                        Toast.makeText(AppointmentDetailsActivity.this, "New appointment created!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        // Display error message if patient doesn't exist
                        Toast.makeText(AppointmentDetailsActivity.this, "Patient not found. Please register the patient first.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    // Display error message if an unexpected error occurs
                    Toast.makeText(AppointmentDetailsActivity.this, "Error creating appointment. Please try again.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    private void runSearch() {
        patientSearchRecyclerAdapter.search(et_firstName.getText().toString(), et_middleName.getText().toString(), et_lastName.getText().toString(), et_dob.getText().toString(), et_phonenumber.getText().toString());
    }

    private void showDatePickerDialog(EditText et) {
        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDateEditText(et);
        };

        new DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void updateDateEditText(EditText et) {
        String dateFormat = "dd/MM/yyyy"; // Specify your date format here
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        et.setText(sdf.format(calendar.getTime()));
    }

    private void showTimePickerDialog() {
        // Get current time
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a TimePickerDialog instance
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Handle time selection
                        String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                        et_time.setText(selectedTime);
                    }
                },
                hour, minute, true); // Pass the current time to initialize the TimePickerDialog

        // Show the TimePickerDialog
        timePickerDialog.show();
    }
}