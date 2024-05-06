package data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AppointmentDao {
    @Query("SELECT * FROM AppointmentModel")
    LiveData<List<AppointmentModel>> getAllAppointments();

    @Insert
    void insertAppointment(AppointmentModel appointment);
}

