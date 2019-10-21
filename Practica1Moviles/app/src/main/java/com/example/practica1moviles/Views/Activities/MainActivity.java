package com.example.practica1moviles.Views.Activities;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.Answer.AnswersDBAccess;
import com.example.practica1moviles.Models.database.DatabaseInitializer;
import com.example.practica1moviles.Models.database.Questions.QuestionsDBAccess;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

public class MainActivity extends AppCompatActivity {

    private User user;
    private UserDBAccess dbAccess;
    public AnswersDBAccess dbAnswers;

    private DatabaseInitializer db = new DatabaseInitializer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.dbAccess = UserDBAccess.get(this);
        Intent mIntent = getIntent();
        String unametag = mIntent.getStringExtra("user");
        this.user= dbAccess.getUser(unametag);
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String color = preferences.getString("color","");
        if (!color.isEmpty())
        changeColor(color);
        db.dbQuestions=  QuestionsDBAccess.get(this);
        db.dbAnswers= AnswersDBAccess.get(this);
        db.initializer();
      //  Button btn_begin = findViewById(R.id.btnBeginGame);
    }

    public void onResume () {
        super.onResume();
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

    public void beginGame(View view){
        Intent intent2 = new Intent (getApplicationContext(), GameActivity.class);
        intent2.putExtra("user",this.user.getNametag());
        startActivityForResult(intent2, 0);
    }


    public void goToOptions (View view){
        Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
        startActivity(intent);
    }

    public void goToRanking (View view){
        Intent intent = new Intent (getApplicationContext(), RankingActivity.class);
        startActivity(intent);
    }
}
