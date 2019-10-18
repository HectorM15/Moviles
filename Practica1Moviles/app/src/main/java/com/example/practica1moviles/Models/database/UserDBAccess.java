package com.example.practica1moviles.Models.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.practica1moviles.Models.User;

import java.util.List;

public class UserDBAccess {
    private static UserDBAccess userDBAccess;

    private userRep userRep;

    private UserDBAccess (Context context) {
        Context appcontext = context.getApplicationContext();
        UserDatabase database = Room.databaseBuilder(appcontext,UserDatabase.class,"user")
                .allowMainThreadQueries().build();
        userRep = database.getUserRep();
    }

    public static UserDBAccess get (Context context){
        if (userDBAccess == null){
            userDBAccess = new UserDBAccess (context);
        }
        return userDBAccess;
    }

    public List<User> getUsers() {
        return userRep.getUsers();
    }

    public User getUser(String nametag) {
        return userRep.getUser(nametag);
    }

    public void addUser(User user) {
        userRep.addUser(user);
    }

    public void updateUser(User user) {
        userRep.updateUser(user);
    }

    public void deleteUser(User user) {
        userRep.deleteUser(user);
    }

}
