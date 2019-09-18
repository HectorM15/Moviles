package com.example.practica1moviles.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.practica1moviles.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      //  Button btn_begin = findViewById(R.id.btnBeginGame);


    }

    public void beginGame(View view){
        Intent intent2 = new Intent (getApplicationContext(), GameActivity.class);
        startActivityForResult(intent2, 0);
    }

}
