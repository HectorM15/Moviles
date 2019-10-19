package com.example.practica1moviles.Models.database;

import android.widget.ImageView;

import com.example.practica1moviles.Models.Answer;
import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.database.Answer.AnswersDBAccess;
import com.example.practica1moviles.Models.database.Questions.QuestionsDBAccess;
import com.example.practica1moviles.Models.database.Questions.QuestionsDatabase;
import com.example.practica1moviles.R;

import java.util.ArrayList;

public class DatabaseInitializer {

    private Questions[] arr_questions = new Questions[9];
    public QuestionsDBAccess dbQuestions;
    public AnswersDBAccess dbAnswers;
    public void initializer() {
        arr_questions[0] = new Questions(1, "¿Cuál de las siguientes tiene más neuronas?", false, 2, false);
        arr_questions[1] = new Questions(2, "¿Cuál fue el primer emperador romano de origen hispano?", false, 2, false);
        arr_questions[2] = new Questions(3, "¿Dónde se produce la respiración celular?", false, 2, false);
        arr_questions[3] = new Questions(4, "¿Cuánto mide el Everest?", false, 2, false);
        arr_questions[4] = new Questions(5, "¿De qué continente son originarios los ornitorrincos?", false, 2, false);
        arr_questions[5] = new Questions(6, "¿Cual obra es de Dalí?", false, 2, true);
        arr_questions[6] = new Questions(7, "¿Cual obra es de Piccaso?", false, 2, true);
        arr_questions[7] = new Questions(8, "¿Cual obra es de Van Gogh?", false, 2, true);
        arr_questions[8] = new Questions(9, "¿Cual obra es de Velázquez?", false, 2, true);

        if (dbQuestions.getQuestions().isEmpty())
            for (int i = 0; i < arr_questions.length; i++) {
                dbQuestions.addQuestions(arr_questions[i]);

            }

        ArrayList<Answer> answerArrayList = new ArrayList<>();
        //PREGUNTA 1
        Answer answer_11 = new Answer(1, 1, "Gato", false);
        Answer answer_12 = new Answer(2, 1, "Banana", false);
        Answer answer_13 = new Answer(3, 1, "Estómago", true);
        Answer answer_14 = new Answer(4, 1, "Brazo", false);

        //PREGUNTA 2
        Answer answer_21 = new Answer(5, 2, "Julio César", false);
        Answer answer_22 = new Answer(6, 2, "Calígula", false);
        Answer answer_23 = new Answer(7, 2, "Trajano", true);
        Answer answer_24 = new Answer(8, 2, "Tibero Claudio Cesar", false);

        //PREGUNTA 3
        Answer answer_31 = new Answer(9,3,"Lisosoma",false);
        Answer answer_32 = new Answer(10,3,"Vacuolas",false);
        Answer answer_33 = new Answer(11,3,"Ribosomas",false);
        Answer answer_34 = new Answer(12,3,"Mitocondrias",true);

        answerArrayList.add(answer_11);
        answerArrayList.add(answer_12);
        answerArrayList.add(answer_13);
        answerArrayList.add(answer_14);

        answerArrayList.add(answer_21);
        answerArrayList.add(answer_22);
        answerArrayList.add(answer_23);
        answerArrayList.add(answer_24);

        answerArrayList.add(answer_31);
        answerArrayList.add(answer_32);
        answerArrayList.add(answer_33);
        answerArrayList.add(answer_34);

        for (int i = 0; i <answerArrayList.size() ; i++) {
            dbAnswers.addQuestions(answerArrayList.get(i));
        }

/*
        //PREGUNTA 4
        arr_questions[3].arr_answer[0]= new Answer("8848 metros",true);
        arr_questions[3].arr_answer[1]= new Answer("8488 metros",false);
        arr_questions[3].arr_answer[2]= new Answer("8884 metros",false);
        arr_questions[3].arr_answer[3]= new Answer("9 kilómetros",false);

        //PREGUNTA 5
        arr_questions[4].arr_answer[0]= new Answer("Australia",true);
        arr_questions[4].arr_answer[1]= new Answer("Europa",false);
        arr_questions[4].arr_answer[2]= new Answer("America",false);
        arr_questions[4].arr_answer[3]= new Answer("Africa",false);

        //PREGUNTA 6
        arr_questions[5].arr_answer[0]= new Answer("Dali",true);
        arr_questions[5].arr_answer[1]= new Answer("VG",false);
        arr_questions[5].arr_answer[2]= new Answer("Velazquez",false);
        arr_questions[5].arr_answer[3]= new Answer("Picasso",false);

        arr_questions[5].arr_answer[0].setImg(R.drawable.dali);
        arr_questions[5].arr_answer[1].setImg(R.drawable.vg);
        arr_questions[5].arr_answer[2].setImg(R.drawable.vg);
        arr_questions[5].arr_answer[3].setImg(R.drawable.picasso);

        //PREGUNTA 7
        arr_questions[6].arr_answer[0]= new Answer("Dali",false);
        arr_questions[6].arr_answer[1]= new Answer("VG",false);
        arr_questions[6].arr_answer[2]= new Answer("Velazquez",false);
        arr_questions[6].arr_answer[3]= new Answer("Picasso",true);


        arr_questions[6].arr_answer[0].setImg(R.drawable.dali);
        arr_questions[6].arr_answer[1].setImg(R.drawable.vg);
        arr_questions[6].arr_answer[2].setImg(R.drawable.vg);
        arr_questions[6].arr_answer[3].setImg(R.drawable.picasso);

        //PREGUNTA 8
        arr_questions[7].arr_answer[0]= new Answer("Dali",false);
        arr_questions[7].arr_answer[1]= new Answer("VG",true);
        arr_questions[7].arr_answer[2]= new Answer("Velazquez",false);
        arr_questions[7].arr_answer[3]= new Answer("Picasso",false);

        arr_questions[7].arr_answer[0].setImg(R.drawable.dali);
        arr_questions[7].arr_answer[1].setImg(R.drawable.vg);
        arr_questions[7].arr_answer[2].setImg(R.drawable.vg);
        arr_questions[7].arr_answer[3].setImg(R.drawable.picasso);

        //PREGUNTA 9
        arr_questions[8].arr_answer[0]= new Answer("Dali",false);
        arr_questions[8].arr_answer[1]= new Answer("VG",false);
        arr_questions[8].arr_answer[2]= new Answer("Velazquez",true);
        arr_questions[8].arr_answer[3]= new Answer("Picasso",false);

        arr_questions[8].arr_answer[0].setImg(R.drawable.dali);
        arr_questions[8].arr_answer[1].setImg(R.drawable.vg);
        arr_questions[8].arr_answer[2].setImg(R.drawable.vg);
        arr_questions[8].arr_answer[3].setImg(R.drawable.picasso);
*/
    }

    public Questions[] getArr_questions() {
        return arr_questions;
    }

    public void setArr_questions(Questions[] arr_questions) {
        this.arr_questions = arr_questions;
    }
}
