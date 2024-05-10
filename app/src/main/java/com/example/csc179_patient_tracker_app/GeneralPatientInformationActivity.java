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

public class GeneralPatientInformationActivity extends AppCompatActivity {
    private boolean editMode = false;

    private EditText patientId;
    private EditText fullName;
    private EditText dob;
    private EditText gender;
    private EditText maritalStatus;
    private EditText bloodGroup;
    private EditText rhFactor;
    private EditText age;
    private EditText phoneNumber;
    private EditText mobileNumber;
    private EditText sms;
    private EditText emailAddress;
    private EditText emergencyFullName;
    private EditText emergencyRelation;
    private EditText emergencyPhoneNumber;

    private Button saveEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_generalpatientinformation_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        patientId = findViewById(R.id.patient_id_field);
        fullName = findViewById(R.id.full_name_field);
        dob = findViewById(R.id.dob_field);
        gender = findViewById(R.id.gender_field);
        maritalStatus = findViewById(R.id.marital_status_field);
        bloodGroup = findViewById(R.id.blood_group_field);
        rhFactor = findViewById(R.id.rh_factor_field);
        age = findViewById(R.id.age_field);
        phoneNumber = findViewById(R.id.phone_number_field);
        mobileNumber = findViewById(R.id.mobile_number_field);
        sms = findViewById(R.id.sms_field);
        emailAddress = findViewById(R.id.email_address_field);
        emergencyFullName = findViewById(R.id.emergency_full_name_field);
        emergencyRelation = findViewById(R.id.emergency_relation_field);
        emergencyPhoneNumber = findViewById(R.id.emergency_phone_number_field);
        saveEditButton = findViewById(R.id.save_edit_button);

        readMode();

        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMode) {
                    readMode();
                    // save to database
                } else {
                    editMode();
                }
            }
        });
    }

    private void readMode() {
        saveEditButton.setText("Edit");
        editMode = false;
        patientId.setFocusable(false);
        fullName.setFocusable(false);
        dob.setFocusable(false);
        gender.setFocusable(false);
        maritalStatus.setFocusable(false);
        bloodGroup.setFocusable(false);
        rhFactor.setFocusable(false);
        age.setFocusable(false);
        phoneNumber.setFocusable(false);
        mobileNumber.setFocusable(false);
        sms.setFocusable(false);
        emailAddress.setFocusable(false);
        emergencyFullName.setFocusable(false);
        emergencyRelation.setFocusable(false);
        emergencyPhoneNumber.setFocusable(false);
        patientId.setFocusableInTouchMode(false);
        fullName.setFocusableInTouchMode(false);
        dob.setFocusableInTouchMode(false);
        gender.setFocusableInTouchMode(false);
        maritalStatus.setFocusableInTouchMode(false);
        bloodGroup.setFocusableInTouchMode(false);
        rhFactor.setFocusableInTouchMode(false);
        age.setFocusableInTouchMode(false);
        phoneNumber.setFocusableInTouchMode(false);
        mobileNumber.setFocusableInTouchMode(false);
        sms.setFocusableInTouchMode(false);
        emailAddress.setFocusableInTouchMode(false);
        emergencyFullName.setFocusableInTouchMode(false);
        emergencyRelation.setFocusableInTouchMode(false);
        emergencyPhoneNumber.setFocusableInTouchMode(false);
        patientId.setClickable(false);
        fullName.setClickable(false);
        dob.setClickable(false);
        gender.setClickable(false);
        maritalStatus.setClickable(false);
        bloodGroup.setClickable(false);
        rhFactor.setClickable(false);
        age.setClickable(false);
        phoneNumber.setClickable(false);
        mobileNumber.setClickable(false);
        sms.setClickable(false);
        emailAddress.setClickable(false);
        emergencyFullName.setClickable(false);
        emergencyRelation.setClickable(false);
        emergencyPhoneNumber.setClickable(false);
    }

    private void editMode() {
        saveEditButton.setText("Save");
        editMode = true;
        patientId.setFocusable(true);
        fullName.setFocusable(true);
        dob.setFocusable(true);
        gender.setFocusable(true);
        maritalStatus.setFocusable(true);
        bloodGroup.setFocusable(true);
        rhFactor.setFocusable(true);
        age.setFocusable(true);
        phoneNumber.setFocusable(true);
        mobileNumber.setFocusable(true);
        sms.setFocusable(true);
        emailAddress.setFocusable(true);
        emergencyFullName.setFocusable(true);
        emergencyRelation.setFocusable(true);
        emergencyPhoneNumber.setFocusable(true);
        patientId.setFocusableInTouchMode(true);
        fullName.setFocusableInTouchMode(true);
        dob.setFocusableInTouchMode(true);
        gender.setFocusableInTouchMode(true);
        maritalStatus.setFocusableInTouchMode(true);
        bloodGroup.setFocusableInTouchMode(true);
        rhFactor.setFocusableInTouchMode(true);
        age.setFocusableInTouchMode(true);
        phoneNumber.setFocusableInTouchMode(true);
        mobileNumber.setFocusableInTouchMode(true);
        sms.setFocusableInTouchMode(true);
        emailAddress.setFocusableInTouchMode(true);
        emergencyFullName.setFocusableInTouchMode(true);
        emergencyRelation.setFocusableInTouchMode(true);
        emergencyPhoneNumber.setFocusableInTouchMode(true);
        patientId.setClickable(true);
        fullName.setClickable(true);
        dob.setClickable(true);
        gender.setClickable(true);
        maritalStatus.setClickable(true);
        bloodGroup.setClickable(true);
        rhFactor.setClickable(true);
        age.setClickable(true);
        phoneNumber.setClickable(true);
        mobileNumber.setClickable(true);
        sms.setClickable(true);
        emailAddress.setClickable(true);
        emergencyFullName.setClickable(true);
        emergencyRelation.setClickable(true);
        emergencyPhoneNumber.setClickable(true);
    }
}