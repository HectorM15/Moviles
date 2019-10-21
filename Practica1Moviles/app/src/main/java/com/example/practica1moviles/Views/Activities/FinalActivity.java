package com.example.practica1moviles.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

public class FinalActivity extends AppCompatActivity {

    private User user;
    private UserDBAccess dbAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent mIntent = getIntent();

        int puntuation = mIntent.getIntExtra("Puntuation", 0);

        this.dbAccess = UserDBAccess.get(this);
        String unametag = mIntent.getStringExtra("user");
        this.user= dbAccess.getUser(unametag);
        setPuntuation(puntuation);

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


    private void setPuntuation(int puntuation){
        TextView dp_punt = findViewById(R.id.displayPunt);
        dp_punt.setText(""+puntuation);
    }

    public void exit (View view){
        finish();
    }

    public void restart(View view){
        Intent intent2 = new Intent (getApplicationContext(), GameActivity.class);
        intent2.putExtra("user",this.user.getNametag());
        startActivity(intent2);
    }
}
