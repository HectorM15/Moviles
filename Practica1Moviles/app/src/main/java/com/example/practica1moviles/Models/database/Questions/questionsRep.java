package com.example.practica1moviles.Models.database.Questions;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.User;

import java.util.List;

@Dao
interface questionsRep {

    @Query("SELECT * FROM Question")
    List<Questions> getQuestions();

    @Query("SELECT * FROM Question WHERE ID_QUESTION LIKE :id")
    Questions getQuestion(Integer id);

    @Insert
    void addQuestion(Questions question);

    @Delete
    void deleteQuestion(Questions question);

    @Update
    void updateQuestion(Questions question);
}
