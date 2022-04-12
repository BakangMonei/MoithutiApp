package com.research.schoolingapp;

/*
 * Done, left only to use the database system and code
 * whereby the username are taken from the database
 *
 * and also the forgot password function
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class twitter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_activity);

        Button loginTwitter = (Button) findViewById(R.id.loginTwitter);
        EditText twitterUsername = (EditText) findViewById(R.id.twitterUsername);
        EditText twitterPassword = (EditText) findViewById(R.id.twitterPassword);

        loginTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(twitterUsername.getText().toString().equals("admin") && twitterPassword.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(twitter.this, "LOGIN Successful!!!! Welcome to the SchoolingApp", Toast.LENGTH_LONG).show();
                    Intent intentTwitterLogIn = new Intent(twitter.this, SuccessfulLogin.class);
                    startActivity(intentTwitterLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(twitter.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}