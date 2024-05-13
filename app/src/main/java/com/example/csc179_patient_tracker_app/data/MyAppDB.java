package com.example.csc179_patient_tracker_app.data;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {
        UserModel.class,
        PatientModel.class,
        AppointmentModel.class,
        EmergencyContactModel.class,
        MedicalHistoryModel.class},
        version = 1)
public abstract class MyAppDB extends RoomDatabase {
    public abstract UserDAO UserDAO();
    public abstract PatientDAO PatientDAO();
    public abstract AppointmentDAO AppointmentDAO();
    public abstract EmergencyContactDAO EmergencyContactDAO();
    public abstract  MedicalHistoryDAO MedicalHistoryDAO();

    private static MyAppDB INSTANCE;

    public static synchronized MyAppDB getDbInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyAppDB.class, "PT_Database")
                    .allowMainThreadQueries()
                    .build();

            // Check if the database is empty before initializing it
//            if (INSTANCE.PatientDAO().getPatientCount() == 0 && INSTANCE.AppointmentDAO().getAppointmentCount() == 0
//                    && INSTANCE.EmergencyContactDAO().getContactCount() == 0)
//            {
//                // Create dummy/initial data to test app functionality
//                new AsyncTask<Void, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(Void... voids) {
//                        // Create 10 patients and appointments, one for each patient
//                        for (int i = 0; i < 10; i++) {
//                            // Create and insert user
//                            UserModel user = new UserModel();
//                                user.firstName = "fName" + i;
//                                user.middleName = "middleName" + i;
//                                user.lastName = "lastName" + i;
//                                user.username = "user" + i;
//                                user.password = "password" + i;
//                                user.email = "user" + i + "@email.com";
//                            INSTANCE.UserDAO().insertUser(user);
//
//                            // Create and insert patient
//                            PatientModel patient = new PatientModel();
//                                patient.firstName = "firstName" + i;
//                                patient.middleName = "middleName" + i;
//                                patient.lastName = "lastName" + i;
//                                patient.dob = "01/1" + i + "/199" + i;
//                                patient.mobilePhone = "(000)-000-000" + i;
//                                patient.email = i + "test@email.com";
//                            INSTANCE.PatientDAO().insertPatient(patient);
//
//                            // Create and insert appointment
//                            AppointmentModel appointment = new AppointmentModel(
//                                    i + 1, // Set patientId for the appointment
//                                    "2024/05/11",
//                                    "1" + i +":00",
//                                    "Appointment for reason " + i
//                            );
//                            INSTANCE.AppointmentDAO().insertAppointment(appointment);
//
//                            // Create and insert emergency contact
//                            EmergencyContactModel emergencyContact = new EmergencyContactModel(
//                                    i+1,
//                                    "Emergency",
//                                    "Contact" + i,
//                                    "(111)-111-111" + i
//                            );
//                            INSTANCE.EmergencyContactDAO().insertEmergencyContact(emergencyContact);
//
//                            // Create and insert medical history data
//                            MedicalHistoryModel medicalHistoryModel = new MedicalHistoryModel();
//                                medicalHistoryModel.patientId = i+1;
//                                medicalHistoryModel.currIllnesses = "currIllnesses" + i;
//                                medicalHistoryModel.prevIllnesses = "prevIllnesses" + i;
//                                medicalHistoryModel.allergies = "allergies" + i;
//                                medicalHistoryModel.bloodGroup = "bloodGroup" + i;
//                                medicalHistoryModel.rhFactor = "rhFactor" + i;
//                            INSTANCE.MedicalHistoryDAO().insertMedicalHistory(medicalHistoryModel);
//                        }
//
//                        return null;
//                    }
//                }.execute();
//            }
        }
        return INSTANCE;
    }
}
