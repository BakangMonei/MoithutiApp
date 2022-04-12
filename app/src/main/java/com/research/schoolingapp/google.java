package com.research.schoolingapp;

/*
 * Done, left only to use the database system and code
 * whereby the username are taken from the database
 * and the forgot password function
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class google extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_activity);

        Button googleSignIn = (Button) findViewById(R.id.googleSignIn);
        EditText googleUsername = (EditText) findViewById(R.id.googleUsername);
        EditText googlePassword = (EditText) findViewById(R.id.googlePassword);

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(googleUsername.getText().toString().equals("bakangmonei2@gmail.com") && googlePassword.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(google.this, "LOGIN Successful!!!! Welcome to the SchoolingApp", Toast.LENGTH_LONG).show();
                    Intent intentGoogleLogIn = new Intent(google.this, SuccessfulLogin.class);
                    startActivity(intentGoogleLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(google.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();

            }
        });
    }
}