package com.example.practica1moviles.Models.database.Questions;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.User;

@Database(entities = {Questions.class},version = 1, exportSchema = true)
public abstract class QuestionsDatabase extends RoomDatabase {
    public abstract com.example.practica1moviles.Models.database.Questions.questionsRep getQuestionsRep ();
}
