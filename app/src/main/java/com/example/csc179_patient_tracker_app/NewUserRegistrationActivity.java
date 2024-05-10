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

import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.data.UserModel;

public class NewUserRegistrationActivity extends AppCompatActivity {

    Button register_button;
    EditText et_firstName, et_lastName, et_username, et_password, et_confirmPw;
    MyAppDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_new_user_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        register_button = findViewById(R.id.register_button);
        et_firstName = findViewById(R.id.first_name_field);
        et_lastName = findViewById(R.id.last_name_field);
        et_username = findViewById(R.id.username_field);
        et_password = findViewById(R.id.password_field);
        et_confirmPw = findViewById(R.id.confirm_password_field);
        db = MyAppDB.getDbInstance(getApplicationContext());
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel user = new UserModel();
                user.firstName  = et_firstName.getText().toString();
                user.lastName  = et_lastName.getText().toString();
                user.username = et_username.getText().toString();
                user.password = et_password.getText().toString();

                if (et_password.getText().toString().equals(et_confirmPw.getText().toString())) {
                    db.UserDAO().insertUser(user);
                    // Display a toast message
                    Toast.makeText(getApplicationContext(), "New User Registered Successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    // Display a toast message
                    Toast.makeText(getApplicationContext(), "Registration Error!", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}