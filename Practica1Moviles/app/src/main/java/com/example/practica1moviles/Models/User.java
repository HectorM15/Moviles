package com.example.practica1moviles.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User implements Comparable <User>  {
    @PrimaryKey
    @NonNull
    private String nametag;
    @ColumnInfo (name = "name")
    private String name;
    @ColumnInfo (name = "password")
    private String password;
    @ColumnInfo (name = "puntuacion")
    private int puntuacion;

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public User(@NonNull String nametag, String name, String password, int puntuacion) {
        this.nametag = nametag;
        this.name = name;
        this.password = password;
        this.puntuacion = puntuacion;
    }

    @NonNull
    public String getNametag() {
        return nametag;
    }

    public void setNametag(@NonNull String nametag) {
        this.nametag = nametag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int compareTo(User o) {
        if (this.puntuacion > o.getPuntuacion()){
            return 1;
        }else if (this.puntuacion < o.getPuntuacion()){
            return -1;
        } else{
            return 0;
        }
    }
}
