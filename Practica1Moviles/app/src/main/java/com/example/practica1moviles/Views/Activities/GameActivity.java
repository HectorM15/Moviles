package com.example.practica1moviles.Views.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.practica1moviles.Models.DatabaseInitializer;
import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.R;

public class GameActivity extends AppCompatActivity {

    private RadioGroup rg_Ans;
    private DatabaseInitializer db = new DatabaseInitializer();
    private Questions [] questions;
    private int num_question=0,puntuacion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        db.initializer();
        setQuestions(num_question);
        setAnswers(num_question);
        rg_Ans = (RadioGroup) findViewById(R.id.rg_Answers);
    }

    public void checkAnswer(View view){

        RadioButton rb_select = (RadioButton)findViewById(rg_Ans.getCheckedRadioButtonId());
        String selected = (String) rb_select.getText();
        System.out.println(checkCorrectAnswer(selected,num_question));

        if (num_question < 4) {
            num_question++;
        }else{
            finish();
        }
        reload(num_question);
    }

    private void setAnswers(int id){

        RadioButton radioButton1= (RadioButton) findViewById(R.id.rb_Answer1);
        RadioButton radioButton2= (RadioButton) findViewById(R.id.rb_Answer2);
        RadioButton radioButton3= (RadioButton) findViewById(R.id.rb_Answer3);
        RadioButton radioButton4= (RadioButton) findViewById(R.id.rb_Answer4);
        radioButton1.setText(questions[id].arr_answer[0].getDs_answer());

        radioButton2.setText(questions[id].arr_answer[1].getDs_answer());
        radioButton3.setText(questions[id].arr_answer[2].getDs_answer());
        radioButton4.setText(questions[id].arr_answer[3].getDs_answer());
    }

    private void setQuestions(int id){

        questions= db.getArr_questions();
        TextView question = (TextView) findViewById(R.id.message);
        question.setText(questions[id].getDs_question());

        TextView puntuation= (TextView)findViewById(R.id.int_punt);
        puntuation.setText("Puntuacion actual: " + puntuacion);
    }

    private boolean checkCorrectAnswer(String selected,int id){

        for (int i = 0; i < questions[id].arr_answer.length; i++) {
            if (selected.equals(questions[id].arr_answer[i].getDs_answer()) && questions[id].arr_answer[i].getIt_correct()){
                puntuacion+=questions[id].getNm_puntuacion();
                return true;
            }
        }
        puntuacion-=questions[id].getNm_puntuacion();
        return false;
    }

    private void reload(int id){
        setQuestions(id);
        setAnswers(id);
    }


}
