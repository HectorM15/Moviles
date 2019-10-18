package com.example.practica1moviles.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

public class LogInActivity extends AppCompatActivity {

    EditText nametag,password;
    private UserDBAccess dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String color = preferences.getString("color","");
        if (!color.isEmpty())
            changeColor(color);

        this.dbAccess = UserDBAccess.get(this);
        this.nametag = findViewById(R.id.login_nametag);
        this.password = findViewById(R.id.login_password);
    }

    public void logIn (View view){
        String unametag = this.nametag.getText().toString();
        String upassword= this.password.getText().toString();

        if (!unametag.isEmpty() && !upassword.isEmpty()){
            User user = dbAccess.getUser(unametag);
            if (user != null){
                if (upassword.equals(user.getPassword())){
                    Toast.makeText(getApplicationContext(), "Bienvenido, " +user.getName(),
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user",user.getNametag());
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Contraseña incorrecta",
                            Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Este usuario no existe",
                        Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Error al rellenar los campos",
                    Toast.LENGTH_LONG).show();
        }
    }


    public void signUp (View view){
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
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
}
