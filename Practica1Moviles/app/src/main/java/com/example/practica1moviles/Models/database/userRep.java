package com.example.practica1moviles.Models.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.practica1moviles.Models.User;

import java.util.List;

@Dao
interface userRep {

    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Query("SELECT * FROM user WHERE nametag LIKE :nnametag")
    User getUser(String nnametag);

    @Insert
    void addUser(User user);

    @Delete
    void deleteUser(User book);

    @Update
    void updateUser(User book);
}
