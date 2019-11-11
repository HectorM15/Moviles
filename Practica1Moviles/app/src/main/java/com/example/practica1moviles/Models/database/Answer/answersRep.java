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

    @Query("SELECT * FROM Answer")
    List<Answer> getAnswers();

    @Query("SELECT * FROM Answer WHERE ID_ANSWER LIKE :id")
    Answer getAnswers(Integer id);

    @Query("SELECT * FROM Answer WHERE ID_QUESTION LIKE :id")
    List<Answer> getAnswersByQuestions(Integer id);

    @Query("SELECT IT_CORRECT FROM Answer WHERE ID_ANSWER = :id")
    Boolean getAnswersCorrect(Integer id);
    @Insert
    void addAnswers(Answer question);

    @Delete
    void deleteAnswers(Answer question);

    @Update
    void updateAnswers(Answer question);
}
