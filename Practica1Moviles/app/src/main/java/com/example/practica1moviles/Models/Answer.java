package com.example.practica1moviles.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Answer",
        indices = {@Index(value = {"ID_ANSWER", "ID_QUESTION"},
        unique = true)},
        foreignKeys = @ForeignKey(entity = Questions.class,
        parentColumns = "ID_QUESTION",
        childColumns = "ID_QUESTION",
        onDelete = ForeignKey.CASCADE))

public class Answer {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID_ANSWER")
    private Integer id;

    @ColumnInfo(name = "ID_QUESTION")
    private Integer id_question;

    @ColumnInfo (name = "DS_ANSWER")
    private String ds_answer;

    @ColumnInfo (name = "IT_CORRECT")
    private Boolean it_correct;

    @ColumnInfo (name = "IMG")
    private int img;

    public Answer(@NonNull Integer id, Integer id_question, String ds_answer, Boolean it_correct) {
        this.id = id;
        this.id_question = id_question;
        this.ds_answer = ds_answer;
        this.it_correct = it_correct;
    }

   /* public Answer(String ds_answer, Boolean it_correct) {
        this.ds_answer = ds_answer;
        this.it_correct = it_correct;
    }*/

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Integer getId_question() {
        return id_question;
    }

    public void setId_question(Integer id_question) {
        this.id_question = id_question;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDs_answer() {
        return ds_answer;
    }

    public void setDs_answer(String ds_answer) {
        this.ds_answer = ds_answer;
    }

    public Boolean getIt_correct() {
        return it_correct;
    }

    public void setIt_correct(Boolean it_correct) {
        this.it_correct = it_correct;
    }
}
