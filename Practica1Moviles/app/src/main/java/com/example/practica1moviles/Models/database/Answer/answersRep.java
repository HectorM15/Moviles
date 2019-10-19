package com.example.practica1moviles.Models.database.Answer;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.practica1moviles.Models.Answer;
import java.util.List;

@Dao
interface answersRep {

    @Query("SELECT * FROM Answers")
    List<Answer> getAnswers();

    @Query("SELECT * FROM Answers WHERE ID_ANSWER LIKE :id")
    Answer getAnswers(Integer id);

    @Query("SELECT * FROM Answers WHERE ID_QUESTIONS LIKE :id")
    List<Answer> getAnswersByQuestions(Integer id);

    @Insert
    void addAnswers(Answer question);

    @Delete
    void deleteAnswers(Answer question);

    @Update
    void updateAnswers(Answer question);
}
