package com.example.practica1moviles.Views.Activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica1moviles.Models.RankingAdapter;
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

        ArrayList <User> ranking = (ArrayList<User>) this.dbAccess.getUsers();

        Collections.sort(ranking);

        final ListView listView = this.findViewById(R.id.ranking);

        RankingAdapter adapter = new RankingAdapter(this, ranking);
        listView.setAdapter(adapter);
    }
}
