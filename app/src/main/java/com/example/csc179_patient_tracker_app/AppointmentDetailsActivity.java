package com.example.csc179_patient_tracker_app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppointmentDetailsActivity extends AppCompatActivity {

    private EditText date;
    private EditText time;

    private Calendar calendar;
    private int hourOfDay;
    private int minute;

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

        calendar = Calendar.getInstance();

        date = findViewById(R.id.date_edittext);
        time = findViewById(R.id.time_edittext);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
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

    private void showTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener timeSetListener = (view, hourOfDay, minute) -> {
            this.hourOfDay = hourOfDay;
            this.minute = minute;
            updateTimeEditText();
        };

        new TimePickerDialog(
                this,
                timeSetListener,
                hourOfDay,
                minute,
                false
        ).show();
    }

    private void updateDateEditText() {
        String dateFormat = "dd/MM/yyyy"; // Specify your date format here
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        date.setText(sdf.format(calendar.getTime()));
    }

    private void updateTimeEditText() {
        int hour = hourOfDay % 12;
        if(hour == 0) hour = 12;
        time.setText(String.format("%d:%02d %s", hour, minute, hourOfDay >= 12 ? "PM" : "AM"));
    }
}