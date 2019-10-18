package com.example.practica1moviles.Views.Activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

import java.util.ArrayList;
import java.util.Collections;

public class RankingActivity extends AppCompatActivity {

    private UserDBAccess dbAccess;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        this.dbAccess = UserDBAccess.get(this);

        LinearLayout myLayout = findViewById(R.id.lista);

        ArrayList <User> ranking = (ArrayList<User>) this.dbAccess.getUsers();

        Collections.sort(ranking);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView[] pairs=new TextView[ranking.size()];
        for(int l=0; l<ranking.size(); l++)
        {
            pairs[l] = new TextView(this);
            pairs[l].setTextSize(15);
            pairs[l].setLayoutParams(lp);
            pairs[l].setId(l);
            pairs[l].setText("Usuario: "+ ranking.get(l).getName() + " Puntuacion: "+ ranking.get(l).getPuntuacion());
            myLayout.addView(pairs[l]);
        }
    }
}
