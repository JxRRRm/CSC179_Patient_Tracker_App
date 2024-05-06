package data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PatientDao {
    @Query("SELECT * FROM PatientModel")
    LiveData<List<PatientModel>> getAllPatients();

    @Insert
    void insertPatient(PatientModel patient);
}

