package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText username , email;
    EditText password , phone;
    Button register , redirectSI;
    public static ArrayList<Users> usersDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.btnRegister);
        redirectSI = findViewById(R.id.btnRedirectSI);
        usersDB = new ArrayList<>();
        usersDB.add(new Users("admin","admin@insorma.com","admin",
                "08211278690","admin"));

        register.setOnClickListener(view -> {
            String user = username.getText().toString();
            String Email = email.getText().toString();
            String pass = password.getText().toString();
            String phonenum = phone.getText().toString();

            if(user.equals("") || Email.equals("") || pass.equals("") || phonenum.equals("")){
                Toast.makeText(MainActivity.this , "Please enter all the field!" , Toast.LENGTH_SHORT).show();
            }else if(user.length() < 3 || user.length() > 20){
                Toast.makeText(MainActivity.this , "Username must between 3 and 20 characters!" , Toast.LENGTH_SHORT).show();
            }else if(!Email.contains(".com")){
                Toast.makeText(MainActivity.this , "Please enter proper Email!" , Toast.LENGTH_SHORT).show();
            }else if(!(pass.matches(".*[A-Za-z].*") && pass.matches(".*[0-9].*") && pass.matches("[A-Za-z0-9]*"))){
                Toast.makeText(MainActivity.this , "Password must be alphanumeric!" , Toast.LENGTH_SHORT).show();
            }else{
                int i , flg = 0;
                for(i = 0; i < usersDB.size() ; i++){
                    if(usersDB.get(i).getUserName().equals(user) || usersDB.get(i).getUserEmail().equals(Email)){
                        flg = 1;
                    }
                }
                if(flg == 0){
                    usersDB.add(new Users(user , Email , user , phonenum , pass));
                    Intent intent = new Intent(getApplicationContext() , Login.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this , "Username / Email is already Used!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        redirectSI.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext() , Login.class);
            startActivity(intent);
        });
    }
}