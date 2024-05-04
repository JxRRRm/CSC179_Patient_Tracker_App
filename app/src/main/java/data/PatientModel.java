package data;

public class PatientModel {
    private int id;
    private String firstName, middleName, lastName, dob, phone, email;
    private boolean isNewPatient;

    // Constructors
    public PatientModel(int id, String firstName, String middleName, String lastName, String dob, String phone, String email, boolean isNewPatient) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.isNewPatient = isNewPatient;
    }
    public PatientModel() {
    }

    // Getters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName;}
    public void setDob(String dob) { this.dob = dob;}
    public String getLastName() { return lastName; }
    public String getDob() { return dob; }
    public String getPhone() { return phone; }
    public String getEmail() { return email;}
    public boolean isNew() { return isNewPatient;}

    // Setters
    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName;}
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email;}
    public void setIsNew(boolean newPatient) { isNewPatient = newPatient; }

    // To string


    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isNewPatient=" + isNewPatient +
                '}';
    }
}
