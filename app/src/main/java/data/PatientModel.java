package data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class PatientModel {
    @PrimaryKey
    public long id; // Adjust data type if necessary
    public String firstName, middleName, lastName, phone, email;
    public Date dob;
    public boolean isNewPatient;

    // Constructor, getters, and setters can also be added if needed

    public PatientModel() {
    }

    public PatientModel(long id, String firstName, String middleName, String lastName, Date dob, String phone, String email, boolean isNewPatient) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.isNewPatient = isNewPatient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isNewPatient() {
        return isNewPatient;
    }

    public void setNewPatient(boolean newPatient) {
        isNewPatient = newPatient;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", isNewPatient=" + isNewPatient +
                '}';
    }
}
