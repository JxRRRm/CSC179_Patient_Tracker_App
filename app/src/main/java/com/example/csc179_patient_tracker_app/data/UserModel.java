package com.example.csc179_patient_tracker_app.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public int id; // Adjust data type if necessary
    @ColumnInfo(name = "profession")
    public String profession;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "middle_name")
    public String middleName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "email_address")
    public String email;

    public UserModel() {
    }

    public UserModel(int id, String profession, String firstName, String middleName, String lastName, String username, String password, String email) {
        this.id = id;
        this.profession = profession;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
