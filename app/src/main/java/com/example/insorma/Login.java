package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email , password;
    Button btnLogIn;
    public static String loggedOnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.LogEmail);
        password = findViewById(R.id.LogPassword);
        btnLogIn = findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(view -> {
            String Email = email.getText().toString();
            String Pass = password.getText().toString();

            int i , flg = 0;
            String uid = "";
            for(i = 0; i < MainActivity.usersDB.size() ; i++){
                if(MainActivity.usersDB.get(i).getUserEmail().equals(Email) && MainActivity.usersDB.get(i).getUserPass().equals(Pass)){
                    flg = 1;
                    uid = MainActivity.usersDB.get(i).getUserName();
                    loggedOnUser = uid;
                }
            }

            if(flg == 0){
                Toast.makeText(Login.this , "Email or Password is wrong!" , Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Login.this , "Login Successful" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Home.class);
            //    intent.putExtra("uid" , uid);
                startActivity(intent);
            }

        });
    }
}