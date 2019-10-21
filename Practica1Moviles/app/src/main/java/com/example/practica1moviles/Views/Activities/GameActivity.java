package com.example.practica1moviles.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica1moviles.Models.Answer;
import com.example.practica1moviles.Models.database.Answer.AnswersDBAccess;
import com.example.practica1moviles.Models.database.Answer.AnswersDatabase;
import com.example.practica1moviles.Models.database.DatabaseInitializer;
import com.example.practica1moviles.Models.Questions;
import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.Questions.QuestionsDBAccess;
import com.example.practica1moviles.Models.database.Questions.QuestionsDatabase;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private User user;
    private UserDBAccess dbAccess;
    private RadioGroup rg_Ans;
    private List<Questions> questions;
    private List<Answer> answer = new ArrayList<>();
    private List<Answer> answerTotal = new ArrayList<>();
    private int random, num_question=0,puntuacion=0;
    private Random randomizer = new Random();
    private QuestionsDBAccess questionsDatabase;
    private AnswersDBAccess answerDatabase;
    ConstraintLayout cl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        cl = findViewById(R.id.content_layout);
        rg_Ans = (RadioGroup) findViewById(R.id.rg_Answers);

        this.dbAccess = UserDBAccess.get(this);
        Intent mIntent = getIntent();
        String unametag = mIntent.getStringExtra("user");
        this.user= dbAccess.getUser(unametag);

        random = randomizer.nextInt(9);
        questionsDatabase =  QuestionsDBAccess.get(this);
        answerDatabase =  AnswersDBAccess.get(this);
        questions= questionsDatabase.getQuestions();
        answerTotal= answerDatabase.getAnswers();
        setQuestions(random);
        setAnswers(random);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String color = preferences.getString("color","");
        if (!color.isEmpty())
            changeColor(color);
    }

    public void changeColor(String color){
        View view1 = this.getWindow().getDecorView();
        switch (color){
            case "Blanco":
                view1.setBackgroundColor(Color.WHITE);
                break;
            case "Rojo":
                view1.setBackgroundColor(Color.RED);
                break;
            case "Amarillo":
                view1.setBackgroundColor(Color.YELLOW);
                break;
            case "Verde":
                view1.setBackgroundColor(Color.GREEN);
                break;
            case "Azul":
                view1.setBackgroundColor(Color.BLUE);
                break;
            case "Negro":
                view1.setBackgroundColor(Color.BLACK);
                break;
        }
    }
    public void checkAnswer(View view){
        RadioButton rb_select = (RadioButton)findViewById(rg_Ans.getCheckedRadioButtonId());
        String selected = (String) rb_select.getText();
        rg_Ans.clearCheck();
        checkCorrectAnswer(selected,random);
        goToNextQuestion();
    }

    private void setAnswers(int id) {

        if (questions.get(id).getHas_img()) {
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
            RadioButton radioButton1 = (RadioButton) findViewById(R.id.rb_Answer1);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_Answer2);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.rb_Answer3);
            RadioButton radioButton4 = (RadioButton) findViewById(R.id.rb_Answer4);
            answer=answerDatabase.getAnswersByQuestions(id);
            radioButton1.setText(answer.get(0).getDs_answer());
            radioButton2.setText(answer.get(1).getDs_answer());
            radioButton3.setText(answer.get(2).getDs_answer());
            radioButton4.setText(answer.get(3).getDs_answer());

        }
    }
    private void setQuestions(int id){
        TextView question = (TextView) findViewById(R.id.message);
        question.setText(questions.get(id).getDs_question());

        TextView puntuation= (TextView)findViewById(R.id.int_punt);
        puntuation.setText("Puntuacion actual: " + puntuacion);
    }

    private boolean checkCorrectAnswer(String selected,int id){
        questions.get(id).setIt_answered(true);
        for (int i = 0; i < answerTotal.size(); i++) {
            if (selected.equals(answerTotal.get(i).getDs_answer()) && answerTotal.get(i).getIt_correct()) {
                puntuacion += questions.get(id).getNm_puntuacion();
                Toast.makeText(getApplicationContext(), "Acertaste",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        }
        puntuacion-=questions.get(id).getNm_puntuacion();
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
       if(questions.get(random).getIt_answered())
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
            finalView.putExtra("user",this.user.getNametag());
            this.user.setPuntuacion(this.puntuacion);
            this.dbAccess.updateUser(this.user);
            Toast.makeText(getApplicationContext(), "Tu puntuación, "+ this.user.getName()+" ha sido de "
                    +this.puntuacion,
                    Toast.LENGTH_LONG).show();
            finishAffinity();
            startActivity(finalView);
        }
    }

}
