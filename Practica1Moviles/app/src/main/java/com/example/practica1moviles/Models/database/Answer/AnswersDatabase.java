package com.example.practica1moviles.Models.database.Answer;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.practica1moviles.Models.Answer;
import com.example.practica1moviles.Models.Questions;

@Database(entities = {Answer.class, Questions.class},version = 1, exportSchema = true)
public abstract class AnswersDatabase extends RoomDatabase {
    public abstract com.example.practica1moviles.Models.database.Answer.answersRep getAnswersRep ();
}
