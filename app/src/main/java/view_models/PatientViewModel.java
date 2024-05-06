package view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.csc179_patient_tracker_app.MyApp;

import java.util.List;

import data.PatientDao;
import data.PatientModel;

public class PatientViewModel extends ViewModel {
    private LiveData<List<PatientModel>> allPatients;
    private PatientDao patientDao;

    public PatientViewModel() {
        patientDao = MyApp.getDatabaseInstance().patientDao();
        allPatients = patientDao.getAllPatients();
    }

    public LiveData<List<PatientModel>> getAllPatients() {
        return allPatients;
    }
}
