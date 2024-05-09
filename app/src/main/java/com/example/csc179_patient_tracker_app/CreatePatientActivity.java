package com.example.csc179_patient_tracker_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.csc179_patient_tracker_app.data.DataBaseHelper;
import com.example.csc179_patient_tracker_app.data.PatientModel;


public class CreatePatientActivity extends AppCompatActivity {
    Button btn_register;
    EditText et_firstName, et_middleName, et_lastName, et_dob,  et_phone, et_email;
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
        et_phone = findViewById(R.id.et_phonenumber);
        et_email = findViewById(R.id.et_medicalId);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatientModel patientModel;

                try {
                    patientModel = new PatientModel(-1, et_firstName.getText().toString(), et_middleName.getText().toString(), et_lastName.getText().toString(),
                            et_dob.getText().toString(), et_phone.getText().toString(), et_email.getText().toString(), true);
                    Toast.makeText(CreatePatientActivity.this, patientModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(CreatePatientActivity.this, "!!", Toast.LENGTH_SHORT).show();
                    patientModel = new PatientModel(-1, "error", "error", "error", "error", "error", "error",false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(CreatePatientActivity.this);
                boolean success = dataBaseHelper.addOne(patientModel);

                Toast.makeText(CreatePatientActivity.this, "Patient Registered!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}