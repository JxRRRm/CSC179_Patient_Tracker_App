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
            if (INSTANCE.PatientDAO().getPatientCount() == 0 && INSTANCE.AppointmentDAO().getAppointmentCount() == 0
                    && INSTANCE.EmergencyContactDAO().getContactCount() == 0)
            {
                // Create dummy/initial data to test app functionality
                INSTANCE.PatientDAO().insertPatient(
                        new PatientModel("Alice", "K", "Smith", "08/01/1973", "561-776-0096"),
                        new PatientModel("Daniel", "M", "Moran", "06/18/1985", "415-873-3241"),
                        new PatientModel("Stacy", "P", "Fant", "08/19/1965", "661-829-6708"),
                        new PatientModel("Dorothy", "G", "Baskett", "08/06/1955", "435-899-8267")
                        );

                UserModel user = new UserModel();
                user.profession = "Doctor";
                user.firstName = "fName";
                user.middleName = "middleName";
                user.lastName = "lastName";
                user.username = "username";
                user.password = "password";
                user.email = "user@email.com";
                INSTANCE.UserDAO().insertUser(user);


                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        // Create 10 patients and appointments, one for each patient
//                        for (int i = 0; i < 10; i++) {
//                            // Create and insert user
//
//                            // Create and insert appointment
////                            AppointmentModel appointment = new AppointmentModel(
////                                    i + 1, // Set patientId for the appointment
////                                    "2024/06/" + (i + 10),
////                                    "1" + i +":00",
////                                    "Appointment for reason " + i
////                            );
////                            INSTANCE.AppointmentDAO().insertAppointment(appointment);
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

                        return null;
                    }
                }.execute();
            }
        }
        return INSTANCE;
    }
}
