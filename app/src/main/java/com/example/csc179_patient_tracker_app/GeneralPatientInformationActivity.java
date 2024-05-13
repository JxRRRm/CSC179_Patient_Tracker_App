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
import com.example.csc179_patient_tracker_app.util.EditTextReadOnlyUtil;

public class GeneralPatientInformationActivity extends AppCompatActivity {
    private boolean editMode = false;

    private EditText patientId;
    private EditText firstName;
    private EditText middleName;
    private EditText lastName;

    private EditText dob;
    private EditText gender;
    private EditText maritalStatus;
    private EditText bloodGroup;
    private EditText rhFactor;
    private EditText phoneNumber;
    private EditText mobileNumber;
    private EditText emailAddress;
    private EditText emergencyFullName;
    private EditText emergencyRelation;
    private EditText emergencyPhoneNumber;
    private Button saveEditButton;

    private PatientModel patientModel;

    private MyAppDB db;

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

        db = MyAppDB.getDbInstance(this);

        patientId = findViewById(R.id.patient_id_field);
        firstName = findViewById(R.id.first_name);
        middleName = findViewById(R.id.middle_name);
        lastName = findViewById(R.id.last_name);
        dob = findViewById(R.id.dob_field);
        gender = findViewById(R.id.gender_field);
        maritalStatus = findViewById(R.id.marital_status_field);
        bloodGroup = findViewById(R.id.blood_group_field);
        rhFactor = findViewById(R.id.rh_factor_field);
        phoneNumber = findViewById(R.id.phone_number_field);
        mobileNumber = findViewById(R.id.mobile_number_field);
        emailAddress = findViewById(R.id.email_address_field);
        emergencyFullName = findViewById(R.id.emergency_full_name_field);
        emergencyRelation = findViewById(R.id.emergency_relation_field);
        emergencyPhoneNumber = findViewById(R.id.emergency_phone_number_field);
        saveEditButton = findViewById(R.id.save_edit_button);

        this.patientModel = getIntent().getParcelableExtra("patient_model");

        // Populate EditText fields with patient data
        if (patientModel != null) {
            patientId.setText(String.valueOf(patientModel.getMedicalId()));
            firstName.setText(patientModel.getFirstName());
            middleName.setText(patientModel.getMiddleName());
            lastName.setText(patientModel.getLastName());
            dob.setText(patientModel.getDob());
            gender.setText(String.valueOf(patientModel.getGender())); // Adjust based on actual gender representation
            maritalStatus.setText(patientModel.getMaritalStatus());
            bloodGroup.setText(patientModel.getBloodGroup());
            rhFactor.setText(patientModel.getRhFactor());
            phoneNumber.setText(patientModel.getHomePhone());
            mobileNumber.setText(patientModel.getMobilePhone());
            emailAddress.setText(patientModel.getEmail());
            emergencyFullName.setText(patientModel.getEmergencyFullName());
            emergencyRelation.setText(patientModel.getEmergencyRelation());
            emergencyPhoneNumber.setText(patientModel.getEmergencyPhoneNumber());
        }

        readMode();

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
    }

    private void saveToDatabase() {
        patientModel.setMedicalId(Integer.parseInt(patientId.getText().toString().trim()));
        patientModel.setFirstName(firstName.getText().toString().trim());
        patientModel.setMiddleName(middleName.getText().toString().trim());
        patientModel.setLastName(lastName.getText().toString().trim());
        patientModel.setDob(dob.getText().toString().trim());
        patientModel.setGender(!gender.getText().toString().trim().isEmpty() ? gender.getText().toString().trim().toUpperCase().charAt(0) : 0);
        patientModel.setMaritalStatus(maritalStatus.getText().toString().trim());
        patientModel.setBloodGroup(bloodGroup.getText().toString().trim());
        patientModel.setRhFactor(rhFactor.getText().toString().trim());
        patientModel.setHomePhone(phoneNumber.getText().toString());
        patientModel.setMobilePhone(mobileNumber.getText().toString());
        patientModel.setEmail(emailAddress.getText().toString());
        patientModel.setEmergencyFullName(emergencyFullName.getText().toString());
        patientModel.setEmergencyRelation(emergencyRelation.getText().toString());
        patientModel.setEmergencyPhoneNumber(emergencyPhoneNumber.getText().toString());

        db.PatientDAO().updatePatient(patientModel);
    }

    private void readMode() {
        saveEditButton.setText("Edit");
        editMode = false;
        EditTextReadOnlyUtil.readOnly(patientId);
        EditTextReadOnlyUtil.readOnly(firstName);
        EditTextReadOnlyUtil.readOnly(middleName);
        EditTextReadOnlyUtil.readOnly(lastName);
        EditTextReadOnlyUtil.readOnly(dob);
        EditTextReadOnlyUtil.readOnly(gender);
        EditTextReadOnlyUtil.readOnly(maritalStatus);
        EditTextReadOnlyUtil.readOnly(bloodGroup);
        EditTextReadOnlyUtil.readOnly(rhFactor);
        EditTextReadOnlyUtil.readOnly(phoneNumber);
        EditTextReadOnlyUtil.readOnly(mobileNumber);
        EditTextReadOnlyUtil.readOnly(emailAddress);
        EditTextReadOnlyUtil.readOnly(emergencyFullName);
        EditTextReadOnlyUtil.readOnly(emergencyRelation);
        EditTextReadOnlyUtil.readOnly(emergencyPhoneNumber);
    }

    private void editMode() {
        saveEditButton.setText("Save");
        editMode = true;
        EditTextReadOnlyUtil.editable(patientId);
        EditTextReadOnlyUtil.editable(firstName);
        EditTextReadOnlyUtil.editable(middleName);
        EditTextReadOnlyUtil.editable(lastName);
        EditTextReadOnlyUtil.editable(dob);
        EditTextReadOnlyUtil.editable(gender);
        EditTextReadOnlyUtil.editable(maritalStatus);
        EditTextReadOnlyUtil.editable(bloodGroup);
        EditTextReadOnlyUtil.editable(rhFactor);
        EditTextReadOnlyUtil.editable(phoneNumber);
        EditTextReadOnlyUtil.editable(mobileNumber);
        EditTextReadOnlyUtil.editable(emailAddress);
        EditTextReadOnlyUtil.editable(emergencyFullName);
        EditTextReadOnlyUtil.editable(emergencyRelation);
        EditTextReadOnlyUtil.editable(emergencyPhoneNumber);
    }
}