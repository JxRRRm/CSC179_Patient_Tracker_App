package data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {PatientModel.class,AppointmentModel.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MyAppDB extends RoomDatabase {
    public abstract PatientDao patientDao();
    public abstract AppointmentDao appointmentDao();
}

