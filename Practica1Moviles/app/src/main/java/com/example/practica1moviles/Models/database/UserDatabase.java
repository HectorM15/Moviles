package com.example.practica1moviles.Models.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.practica1moviles.Models.User;

@Database(entities = {User.class},version = 1, exportSchema = true)
public abstract class UserDatabase extends RoomDatabase {
    public abstract userRep getUserRep ();
}
