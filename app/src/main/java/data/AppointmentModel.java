package data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = PatientModel.class,
        parentColumns = "id",
        childColumns = "patientId",
        onDelete = ForeignKey.CASCADE))
public class AppointmentModel {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long patientId;
    public Date appointmentDate;
    public String reason;

    // Constructor, getters, and setters can also be added if needed

    public AppointmentModel(long id, long patientId, Date appointmentDate, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
