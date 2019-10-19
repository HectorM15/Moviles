package com.example.practica1moviles.Models.database.Answer;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.practica1moviles.Models.Questions;

@Database(entities = {Questions.class},version = 1)
public abstract class AnswersDatabase extends RoomDatabase {
    public abstract com.example.practica1moviles.Models.database.Answer.answersRep getAnswersRep ();
}
