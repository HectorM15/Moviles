package com.example.practica1moviles.Views.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.practica1moviles.R;

public class OptionsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private String musica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Spinner spinner = findViewById(R.id.colours);

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.colours,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        musica = preferences.getString("music","");

        Switch music = findViewById(R.id.music);


        assert musica != null;
        if (musica.equals("true")){
            music.setOnCheckedChangeListener (null);
            music.setChecked(true);
        }

        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                if (isChecked) {
                    editor.putString("music","true");
                } else {
                    editor.putString("music","false");
                }
                editor.commit();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("color",text);
        editor.commit();
        View view1 = this.getWindow().getDecorView();
        switch (text){
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




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void save (View view) {
        finish();
    }
}
