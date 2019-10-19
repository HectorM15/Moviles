package com.example.practica1moviles.Models.database.Answer;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.practica1moviles.Models.Answer;
import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.Questions.QuestionsDatabase;

import java.util.List;

public class AnswersDBAccess {
    private static AnswersDBAccess answersDBAccess;

    private com.example.practica1moviles.Models.database.Answer.answersRep answersRep;

    private AnswersDBAccess(Context context) {
        Context appcontext = context.getApplicationContext();
        AnswersDatabase database = Room.databaseBuilder(appcontext,AnswersDatabase.class,"Answer")
                .allowMainThreadQueries().build();
        answersRep = database.getAnswersRep();
    }

    public static AnswersDBAccess get (Context context){
        if (answersDBAccess == null){
            answersDBAccess = new AnswersDBAccess(context);
        }
        return answersDBAccess;
    }

    public List<Answer> getAnswers() {
        return answersRep.getAnswers();
    }

    public Answer getAnswer(Integer id) {
        return answersRep.getAnswers(id);
    }

    public void addQuestions(Answer questions) {
        answersRep.addAnswers(questions);
    }

    public void updateQuestions(Answer questions) {
        answersRep.updateAnswers(questions);
    }

    public void deleteQuestions(Answer questions) {
        answersRep.deleteAnswers(questions);
    }

}
