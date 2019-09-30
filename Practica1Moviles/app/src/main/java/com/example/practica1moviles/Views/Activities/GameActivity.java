package com.example.practica1moviles.Views.Activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica1moviles.Models.DatabaseInitializer;
import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.R;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private RadioGroup rg_Ans;
    private DatabaseInitializer db = new DatabaseInitializer();
    private Questions [] questions;
    private int random, num_question=0,puntuacion=0;
    private Random randomizer = new Random();
    ConstraintLayout cl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cl = findViewById(R.id.content_layout);

        setContentView(R.layout.activity_game);
        db.initializer();
        random = randomizer.nextInt(9);
        questions= db.getArr_questions();
        setQuestions(random);
        setAnswers(random);
        rg_Ans = (RadioGroup) findViewById(R.id.rg_Answers);
    }

    public void checkAnswer(View view){
        RadioButton rb_select = (RadioButton)findViewById(rg_Ans.getCheckedRadioButtonId());
        String selected = (String) rb_select.getText();
        checkCorrectAnswer(selected,random);
        goToNextQuestion();
    }

    private void setAnswers(int id) {

        if (questions[id].getHas_img()) {
            if (findViewById(R.id.content_images).getVisibility() != View.VISIBLE) {
                findViewById(R.id.content_images).setVisibility(View.VISIBLE);
                findViewById(R.id.content_radio).setVisibility(View.GONE);
            }
            ImageButton answer1 = (ImageButton) findViewById(R.id.answer_1);
            ImageButton answer2 = (ImageButton) findViewById(R.id.answer_2);
            ImageButton answer3 = (ImageButton) findViewById(R.id.answer_3);
            ImageButton answer4 = (ImageButton) findViewById(R.id.answer_4);
        } else {
            if (findViewById(R.id.content_radio).getVisibility() != View.VISIBLE) {
                findViewById(R.id.content_images).setVisibility(View.GONE);
                findViewById(R.id.content_radio).setVisibility(View.VISIBLE);
            }
            rg_Ans.clearCheck();
            //setContentView(R.layout.content_questions);
            RadioButton radioButton1 = (RadioButton) findViewById(R.id.rb_Answer1);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_Answer2);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.rb_Answer3);
            RadioButton radioButton4 = (RadioButton) findViewById(R.id.rb_Answer4);

            radioButton1.setText(questions[id].arr_answer[0].getDs_answer());
            radioButton2.setText(questions[id].arr_answer[1].getDs_answer());
            radioButton3.setText(questions[id].arr_answer[2].getDs_answer());
            radioButton4.setText(questions[id].arr_answer[3].getDs_answer());

        }
    }
    private void setQuestions(int id){
        TextView question = (TextView) findViewById(R.id.message);
        question.setText(questions[id].getDs_question());

        TextView puntuation= (TextView)findViewById(R.id.int_punt);
        puntuation.setText("Puntuacion actual: " + puntuacion);
    }

    private boolean checkCorrectAnswer(String selected,int id){
        questions[id].setIt_answered(true);
        for (int i = 0; i < questions[id].arr_answer.length; i++) {
            if (selected.equals(questions[id].arr_answer[i].getDs_answer()) && questions[id].arr_answer[i].getIt_correct()){
                puntuacion+=questions[id].getNm_puntuacion();
                Toast.makeText(getApplicationContext(), "Acertaste",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        }
        puntuacion-=questions[id].getNm_puntuacion();
        Toast.makeText(getApplicationContext(), "Fallaste",
                Toast.LENGTH_LONG).show();
        return false;
    }

    private void reload(int id){
        setQuestions(id);
        setAnswers(id);
    }

    public void checkImageAnswer(View view){
        String selected = view.getTag().toString();
        checkCorrectAnswer(selected,random);
        goToNextQuestion();
    }

    private int getRandomQuestionNotAnswered(){
       int random = randomizer.nextInt(9);
       if(questions[random].getIt_answered())
           random = getRandomQuestionNotAnswered();
       // System.out.println(random);
        return random;
    }

    private void goToNextQuestion(){
        random = getRandomQuestionNotAnswered();

        if (num_question < 4) {
            num_question++;
            reload(random);
        }else{
            Intent finalView = new Intent(GameActivity.this, FinalActivity.class);
            finalView.putExtra("Puntuation", this.puntuacion);
            finishAffinity();
            startActivity(finalView);
        }
    }

}
