package com.research.schoolingapp;

/*
 * 1. Done, left only to use the database system and code whereby the username are taken from the database.
 * This is the real main class
 *
 * Classes to be coded: BAC, UB, accreditedCourses, FinAid & forgot password
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;


// For linking
import android.content.Intent;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username); //
        TextView password = (TextView) findViewById(R.id.password); //

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn); // Working
        MaterialButton forgotpass = (MaterialButton) findViewById(R.id.forgotpass); // Working (Layout Left)
        MaterialButton signupbtn = (MaterialButton) findViewById(R.id.signupbtn); // Working

        ImageButton instasignup = (ImageButton) findViewById(R.id.instasignup);//
        ImageButton twittersignup = (ImageButton) findViewById(R.id.twittersignup);//
        ImageButton fbsignup = (ImageButton) findViewById(R.id.fbsignup);//
        ImageButton googlesignup = (ImageButton) findViewById(R.id.googlesignup);



        // admin and ADMIN & Successful LogIn
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(MainActivity.this, "LOGIN Successful!!!!", Toast.LENGTH_LONG).show();
                    Intent intentLogIn = new Intent(MainActivity.this, SuccessfulLogin.class);
                    startActivity(intentLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(MainActivity.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();
            }
        });
        // signUpButton
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Please use the right words", Toast.LENGTH_LONG).show();
                Intent intentSignUp = new Intent(MainActivity.this, signUp.class);
                startActivity(intentSignUp);
            }
        });

        // forgotPassword
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password != username){
                    Toast.makeText(MainActivity.this, "Please check your emails password or reset it", Toast.LENGTH_LONG).show();
                    Intent intentForgotPass = new Intent(MainActivity.this, forgotPassword.class);
                    startActivity(intentForgotPass);
                }
                else{
                    Toast.makeText(MainActivity.this, "Your LogIn initials are OKAY!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // instaSignIn
        instasignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Use your Instagram initials to sign in", Toast.LENGTH_LONG).show();
                Intent intentInstaSign = new Intent(MainActivity.this, instagram.class);
                startActivity(intentInstaSign);
            }
        });


        // twitterSignIn
        twittersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Use your Twitter initials to sign in", Toast.LENGTH_LONG).show();
                Intent intentTwitterSign = new Intent(MainActivity.this, twitter.class);
                startActivity(intentTwitterSign);
            }
        });

        // facebookSignIn
        fbsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Use your Facebook initials to sign in", Toast.LENGTH_LONG).show();
                Intent intentFacebookSign = new Intent(MainActivity.this, facebook.class);
                startActivity(intentFacebookSign);
            }
        });

        // googleSignIn
        googlesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Use your Google initials to sign in", Toast.LENGTH_LONG).show();
                Intent intentGoogleSign = new Intent(MainActivity.this, google.class);
                startActivity(intentGoogleSign);
            }
        });
    }
}