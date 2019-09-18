package com.example.practica1moviles.Views.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.practica1moviles.R;

public class FinalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent mIntent = getIntent();
        int puntuation = mIntent.getIntExtra("Puntuation", 0);
        System.out.println(puntuation);
        TextView dp_punt = findViewById(R.id.displayPunt);
        dp_punt.setText(""+puntuation);
    }

    public void exit (View view){
        finish();
    }

    public void restart(View view){
        startActivity(new Intent(FinalActivity.this, GameActivity.class));
    }
}
