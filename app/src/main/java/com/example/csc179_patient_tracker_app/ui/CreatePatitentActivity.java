/*
 com.example.csc179_patient_tracker_app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatePatientActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private EditText editTextFirstInitial;
    private EditText editTextMiddleInitial;
    private EditText editTextLastInitial;
    // Other EditText fields and UI components

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_patient);

        // Instantiate the DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Initialize EditText fields and other UI components
        editTextFirstInitial = findViewById(R.id.editTextText2);
        editTextMiddleInitial = findViewById(R.id.editTextText4);
        editTextLastInitial = findViewById(R.id.editTextText5);

        // Set up onClickListener for the CREATE button
        Button buttonCreate = findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve patient information from EditText fields
                String firstInitial = editTextFirstInitial.getText().toString();
                String middleInitial = editTextMiddleInitial.getText().toString();
                String lastInitial = editTextLastInitial.getText().toString();
                // Get other patient information from EditText fields

                // Save patient information to the database using dbHelper
                // You would implement this method in the DatabaseHelper class
                //--long patientId = dbHelper.insertPatient(firstInitial, middleInitial, lastInitial, /* other patient info *//*);

                // Optionally, you can show a toast message or navigate to another screen/*

            }
        });
    }

    // Other methods of your activity
}

*/