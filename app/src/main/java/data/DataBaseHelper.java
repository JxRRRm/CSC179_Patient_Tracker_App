package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String PATIENT_TABLE = "PATIENT_TABLE";
    public static final String COLUMN_PATIENT_FNAME = "PATIENT_FNAME";
    public static final String COLUMN_PATIENT_MNAME = "PATIENT_MNAME";
    public static final String COLUMN_PATIENT_LNAME = "PATIENT_LNAME";
    public static final String COLUMN_PATIENT_DOB = "PATIENT_DOB";
    public static final String COLUMN_PATIENT_EMAIL = "PATIENT_EMAIL";
    public static final String COLUMN_PATIENT_PHONE = "PATIENT_PHONE";
    public static final String COLUMN_PATIENT_ISNEW = "PATIENT_ISNEW";
    public static final String COLUMN_ID = "ID";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "patient.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + PATIENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                        + COLUMN_PATIENT_FNAME + " TEXT, " + COLUMN_PATIENT_MNAME + " TEXT, " + COLUMN_PATIENT_LNAME + " TEXT, "
                                        + COLUMN_PATIENT_DOB + " TEXT, " + COLUMN_PATIENT_EMAIL + " TEXT, " + COLUMN_PATIENT_PHONE + " TEXT, "
                                        + COLUMN_PATIENT_ISNEW + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(PatientModel patientModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PATIENT_FNAME, patientModel.getFirstName());
        cv.put(COLUMN_PATIENT_MNAME, patientModel.getMiddleName());
        cv.put(COLUMN_PATIENT_LNAME, patientModel.getLastName());
        cv.put(COLUMN_PATIENT_DOB, patientModel.getDob());
        cv.put(COLUMN_PATIENT_PHONE, patientModel.getPhone());
        cv.put(COLUMN_PATIENT_EMAIL, patientModel.getEmail());
        cv.put(COLUMN_PATIENT_ISNEW, patientModel.isNew());

        long insert = db.insert(PATIENT_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public List<PatientModel> getEveryone() {
        List<PatientModel> returnList = new ArrayList<>();

        // get data from database
        String queryString = "SELECT *FROM " + PATIENT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new patient objects. Put them into the list
            do {
                int patient_ID = cursor.getInt(0);
                String patientFName = cursor.getString(1);
                String patientMName = cursor.getString(2);
                String patientLName = cursor.getString(3);
                String patientDOB = cursor.getString(4);
                String patientPhone = cursor.getString(5);
                String patientEmail= cursor.getString(6);
                boolean patientIsNew = cursor.getInt(7) == 1 ? true : false;

                PatientModel newPatient = new PatientModel(patient_ID, patientFName, patientMName, patientLName,
                                                            patientDOB, patientPhone, patientEmail, patientIsNew);
                returnList.add(newPatient);

            } while (cursor.moveToFirst());
        }
        else {
            // failure. do not add anything to the list.
        }
        // close both the cursor and the db when done.
        cursor.close();
        db.close();

        return returnList;
    }

    public List<PatientModel> searchPatients(String query) {
        List<PatientModel> patients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM patients WHERE name LIKE ?", new String[]{"%" + query + "%"});
        if (cursor.moveToFirst()) {
            do {
                PatientModel patient = new PatientModel();
                patient.setId(cursor.getInt(0));
                patient.setFirstName(cursor.getString(1));
                patient.setMiddleName(cursor.getString(2));
                patient.setLastName(cursor.getString(3));
                patient.setDob(cursor.getString(4));
                patient.setPhone(cursor.getString(5));
                patient.setEmail(cursor.getString(6));
                patient.setIsNew(cursor.getInt(7) == 1 ? true : false);
                patients.add(patient);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return patients;
    }
}
