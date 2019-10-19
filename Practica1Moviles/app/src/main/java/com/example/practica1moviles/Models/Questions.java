package com.example.practica1moviles.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Question",
        indices = {@Index("ID_QUESTION")})
public class Questions {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name ="ID_QUESTION")
    private int id;

    @ColumnInfo(name = "DS_QUESTION")
    private String ds_question;

    @ColumnInfo(name = "IT_ANSWERED")
    private Boolean it_answered;

    @ColumnInfo(name = "NM_PUNTUACION")
    private Integer nm_puntuacion;

    @ColumnInfo(name = "HAS_IMG")
    private Boolean has_img;




    public Questions(@NonNull Integer id, String ds_question, Boolean it_answered, Integer nm_puntuacion, Boolean has_img) {
        this.id=id;
        this.ds_question = ds_question;
        this.it_answered = it_answered;
        this.nm_puntuacion = nm_puntuacion;
        this.has_img = has_img;
      //  this.arr_answer = new Answer[4];
    }


 /*   public Questions(String ds_question, Boolean it_answered, Integer nm_puntuacion, Boolean has_img) {
        this.ds_question = ds_question;
        this.it_answered = it_answered;
        this.nm_puntuacion = nm_puntuacion;
        this.has_img = has_img;
        this.arr_answer = new Answer[4];
    }*/


    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public Boolean getHas_img() {
        return has_img;
    }

    public void setHas_img(Boolean has_img) {
        this.has_img = has_img;
    }

    public String getDs_question() {
        return ds_question;
    }

    public void setDs_question(String ds_question) {
        this.ds_question = ds_question;
    }

    public Boolean getIt_answered() {
        return it_answered;
    }

    public void setIt_answered(Boolean it_answered) {
        this.it_answered = it_answered;
    }

    public Integer getNm_puntuacion() {
        return nm_puntuacion;
    }

    public void setNm_puntuacion(Integer nm_puntuacion) {
        this.nm_puntuacion = nm_puntuacion;
    }
}
