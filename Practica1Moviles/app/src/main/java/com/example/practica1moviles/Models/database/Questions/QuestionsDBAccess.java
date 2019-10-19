package com.example.practica1moviles.Models.database.Questions;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.UserDatabase;

import java.util.List;

public class QuestionsDBAccess {
    private static QuestionsDBAccess questionsDBAccess;

    private com.example.practica1moviles.Models.database.Questions.questionsRep questionsRep;

    private QuestionsDBAccess(Context context) {
        Context appcontext = context.getApplicationContext();
        QuestionsDatabase database = Room.databaseBuilder(appcontext,QuestionsDatabase.class,"Questions")
                .allowMainThreadQueries().build();
        questionsRep = database.getQuestionsRep();
    }

    public static QuestionsDBAccess get (Context context){
        if (questionsDBAccess == null){
            questionsDBAccess = new QuestionsDBAccess(context);
        }
        return questionsDBAccess;
    }

    public List<Questions> getQuestions() {
        return questionsRep.getQuestions();
    }

    public Questions getQuestion(Integer id) {
        return questionsRep.getQuestion(id);
    }

    public void addQuestions(Questions questions) {
        questionsRep.addQuestion(questions);
    }

    public void updateQuestions(Questions questions) {
        questionsRep.updateQuestion(questions);
    }

    public void deleteQuestions(Questions questions) {
        questionsRep.deleteQuestion(questions);
    }

}
