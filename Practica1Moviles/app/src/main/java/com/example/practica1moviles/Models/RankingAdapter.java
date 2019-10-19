package com.example.practica1moviles.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practica1moviles.R;

import java.util.ArrayList;
import java.util.List;

public class RankingAdapter extends ArrayAdapter <User> {

    private ArrayList <User> users;
    private  Context context;

    public RankingAdapter(@NonNull Context context, List <User> users) {
        super(context, -1,users);
        this.users = (ArrayList<User>) users;
        this.context = context;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView (int position, View view, ViewGroup parent){
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.ranking_view, parent, false);
            TextView nameLabel = view.findViewById(R.id.ItemName);
            TextView scoreLabel = view.findViewById(R.id.ItemScore);

            nameLabel.setText("Nombre: " + this.users.get(position).getNametag());
            scoreLabel.setText("Puntuación: " + this.users.get(position).getPuntuacion());
        }
        return view;
    }
}
