package com.example.csc179_patient_tracker_app.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.csc179_patient_tracker_app.data.UserModel;


@Dao
public interface UserDAO {
    @Insert
    void insertUser(UserModel... contactInfo);
    @Update
    void updateUser(UserModel contactInfo);
    @Delete
    void deleteUser(UserModel contactInfo);
    @Query("SELECT * FROM users WHERE username = :username")
    UserModel getUserByUsername(String username);
}
