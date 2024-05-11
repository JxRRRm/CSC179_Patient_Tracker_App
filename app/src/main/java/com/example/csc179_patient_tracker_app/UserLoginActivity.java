package com.example.csc179_patient_tracker_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.data.UserModel;

public class UserLoginActivity extends AppCompatActivity {
    private TextView registerLink;
    private EditText et_username, et_password;
    private Button loginButton;
    MyAppDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_user_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        registerLink = findViewById(R.id.link_register);
        loginButton = findViewById(R.id.login_button);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        db = MyAppDB.getDbInstance(getApplicationContext());

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navigateRegistration = new Intent(UserLoginActivity.this, NewUserRegistrationActivity.class);
                startActivity(navigateRegistration);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the user from the database based on the username
                if (et_username.getText().toString().trim().isEmpty() || et_password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter username AND password!", Toast.LENGTH_SHORT).show();
                }
                else {
                    String username = et_username.getText().toString();
                    String password = et_password.getText().toString();
                    UserModel user = db.UserDAO().getUserByUsername(username);
                    if (user == null) {
                        Toast.makeText(getApplicationContext(), "No such user!", Toast.LENGTH_SHORT).show();
                    } else if (user.password.equals(password)) {
                        Intent intent = new Intent(UserLoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Incorrect password!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}