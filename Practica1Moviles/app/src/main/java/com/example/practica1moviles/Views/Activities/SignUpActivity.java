package com.example.practica1moviles.Views.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica1moviles.Models.User;
import com.example.practica1moviles.Models.database.UserDBAccess;
import com.example.practica1moviles.R;

public class SignUpActivity extends AppCompatActivity {

    private UserDBAccess dbAccess;
    private EditText name,nametag,password;
    private Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String color = preferences.getString("color","");
        if (!color.isEmpty())
            changeColor(color);

        this.dbAccess = UserDBAccess.get(this);

        this.nametag = findViewById(R.id.register_nametag);
        this.name = findViewById(R.id.register_name);
        this.password = findViewById(R.id.register_password);
        this.confirm = findViewById(R.id.register_button);
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

    public void saveUser(View view){
        String unametag = this.nametag.getText().toString();
        String uname = this.name.getText().toString();
        String upassword = this.password.getText().toString();

        if (this.dbAccess.getUser(unametag)==null) {
            if (!unametag.isEmpty() && !uname.isEmpty() && !upassword.isEmpty()) {
                User newuser = new User(unametag, uname, upassword, 0);
                this.dbAccess.addUser(newuser);
                Toast.makeText(getApplicationContext(), "Se ha creado su usuario satisfactoriamente",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error al rellenar los campos",
                        Toast.LENGTH_LONG).show();
            }
        }
        finish();
    }

}
