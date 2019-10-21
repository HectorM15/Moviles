package com.example.practica1moviles.Models.database;

import android.widget.ImageView;

import com.example.practica1moviles.Models.Answer;
import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.database.Answer.AnswersDBAccess;
import com.example.practica1moviles.Models.database.Questions.QuestionsDBAccess;
import com.example.practica1moviles.Models.database.Questions.QuestionsDatabase;
import com.example.practica1moviles.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {

    private Questions[] arr_questions = new Questions[9];
    ArrayList<Answer> answerArrayList = new ArrayList<>();
    public QuestionsDBAccess dbQuestions;
    public AnswersDBAccess dbAnswers;
    public void initializer() {

        List<Questions> a = dbQuestions.getQuestions();
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


        //PREGUNTA 1
        Answer answer_11 = new Answer(1, 1, "Gato", false);
        Answer answer_12 = new Answer(2, 1, "Banana", false);
        Answer answer_13 = new Answer(3, 1, "Estómago", true);
        Answer answer_14 = new Answer(4, 1, "Brazo", false);

        //PREGUNTA 2
        Answer answer_21 = new Answer(5, 2, "Julio César", false);
        Answer answer_22 = new Answer(6, 2, "Calígula", false);
        Answer answer_23 = new Answer(7, 2, "Trajano", true);
        Answer answer_24 = new Answer(8,2, "Tibero Claudio Cesar", false);

        //PREGUNTA 3
        Answer answer_31 = new Answer(9,3,"Lisosoma",false);
        Answer answer_32 = new Answer(10,3,"Vacuolas",false);
        Answer answer_33 = new Answer(11,3,"Ribosomas",false);
        Answer answer_34 = new Answer(12,3,"Mitocondrias",true);



        //PREGUNTA 4
        Answer answer_41 = new Answer(13,4,"8848 metros",true);
        Answer answer_42 =new Answer(14,4,"8488 metros",false);
        Answer answer_43 = new Answer(15,4,"8884 metros",false);
        Answer answer_44 =new Answer(16,4,"9 kilómetros",false);

        //PREGUNTA 5
        Answer answer_51 = new Answer(17,5,"Australia",true);
        Answer answer_52 = new Answer(18,5,"Europa",false);
        Answer answer_53 =new Answer(19,5,"America",false);
        Answer answer_54 = new Answer(20,5,"Africa",false);

        //PREGUNTA 6
        Answer answer_61 = new Answer(21,6,"Dali",true);
        Answer answer_62 = new Answer(22,6,"VG",false);
        Answer answer_63 = new Answer(23,6,"Velazquez",false);
        Answer answer_64 = new Answer(24,6,"Picasso",false);

        answer_61.setImg(R.drawable.dali);
        answer_62.setImg(R.drawable.vg);
        answer_63.setImg(R.drawable.vg);
        answer_64.setImg(R.drawable.picasso);

        //PREGUNTA 7
        Answer answer_71 = new Answer(25,7,"Dali",false);
        Answer answer_72 =new Answer(26,7,"VG",false);
        Answer answer_73 = new Answer(27,7,"Velazquez",false);
        Answer answer_74 = new Answer(28,7,"Picasso",true);


        answer_71.setImg(R.drawable.dali);
        answer_72.setImg(R.drawable.vg);
        answer_73.setImg(R.drawable.vg);
        answer_74.setImg(R.drawable.picasso);

        //PREGUNTA 8
        Answer answer_81 = new Answer(29,8,"Dali",false);
        Answer answer_82 =new Answer(30,8,"VG",true);
        Answer answer_83 = new Answer(31,8,"Velazquez",false);
        Answer answer_84 = new Answer(32,8,"Picasso",false);

        answer_81.setImg(R.drawable.dali);
        answer_82.setImg(R.drawable.vg);
        answer_83.setImg(R.drawable.vg);
        answer_84.setImg(R.drawable.picasso);

        //PREGUNTA 9
        Answer answer_91 =  new Answer(33,9,"Dali",false);
        Answer answer_92 = new Answer(34,9,"VG",false);
        Answer answer_93 =  new Answer(35,9,"Velazquez",true);
        Answer answer_94 =  new Answer(36,9,"Picasso",false);

        answer_91.setImg(R.drawable.dali);
        answer_92.setImg(R.drawable.vg);
        answer_93.setImg(R.drawable.vg);
        answer_94.setImg(R.drawable.picasso);

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

        answerArrayList.add(answer_41);
        answerArrayList.add(answer_42);
        answerArrayList.add(answer_43);
        answerArrayList.add(answer_44);

        answerArrayList.add(answer_51);
        answerArrayList.add(answer_52);
        answerArrayList.add(answer_53);
        answerArrayList.add(answer_54);

        answerArrayList.add(answer_61);
        answerArrayList.add(answer_62);
        answerArrayList.add(answer_63);
        answerArrayList.add(answer_64);

        answerArrayList.add(answer_71);
        answerArrayList.add(answer_72);
        answerArrayList.add(answer_73);
        answerArrayList.add(answer_74);

        answerArrayList.add(answer_81);
        answerArrayList.add(answer_82);
        answerArrayList.add(answer_83);
        answerArrayList.add(answer_84);

        answerArrayList.add(answer_91);
        answerArrayList.add(answer_92);
        answerArrayList.add(answer_93);
        answerArrayList.add(answer_94);
        if (dbAnswers.getAnswers().size()<36)
            for (int i = 0; i <answerArrayList.size() ; i++) {
                dbAnswers.addAnswer(answerArrayList.get(i));
            }

    }

    public Questions[] getArr_questions() {
        return arr_questions;
    }

    public void setArr_questions(Questions[] arr_questions) {
        this.arr_questions = arr_questions;
    }
}
