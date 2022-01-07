package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class login_page extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    EditText username,password;

    final String File_Name= "example.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username =(EditText) findViewById(R.id.inputEmail);
        password =(EditText) findViewById(R.id.inputPassword);

        Button loginbtn = (Button) findViewById(R.id.btnLogin);
        drawerLayout=findViewById(R.id.drawer_layout);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( (username.getText().toString().equals("nour") && password.getText().toString().equals("nour")) ||
                    (username.getText().toString().equals("hanin") && password.getText().toString().equals("hanin")) ||
                    (username.getText().toString().equals("maryam") && password.getText().toString().equals("maryam"))){
                    Intent intent = new Intent(login_page.this,MainActivity.class);
                    Toast.makeText(login_page.this,"LOGIN Ok !!!",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else
                    Toast.makeText(login_page.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });



    }

}
