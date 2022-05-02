package com.research.schoolingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/*
* 1. BAC
* 2. UB
* 3. FinAid
* 4. Accredited Courses
* 5. Apply Here
* */

public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successful_login_activity);

        ImageButton userProfile = (ImageButton) findViewById(R.id.userProfile);
        Button BotswanaAccountancyCollege = (Button) findViewById(R.id.BotswanaAccountancyCollege);
        Button UniversityOfBotswana = (Button) findViewById(R.id.UniversityOfBotswana);
        Button accreditedCourses = (Button) findViewById(R.id.accreditedCourses);
        Button financialAid = (Button) findViewById(R.id.financialAid);


        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "User profile", Toast.LENGTH_LONG).show();
                Intent intentUserProfile = new Intent(SuccessfulLogin.this, userProfile.class);
                startActivity(intentUserProfile);
            }
        });
        BotswanaAccountancyCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to BAC Portal", Toast.LENGTH_LONG).show();
                Intent intentBAC = new Intent(SuccessfulLogin.this, BotswanaAccountancyCollege.class);
                startActivity(intentBAC);
            }
        });

        UniversityOfBotswana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to UB Portal", Toast.LENGTH_LONG).show();
                Intent intentUB = new Intent(SuccessfulLogin.this, UniversityOfBotswana.class);
                startActivity(intentUB);
            }
        });

        accreditedCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to Accredited Course Portal", Toast.LENGTH_LONG).show();
                Intent intentAccreditedCourses = new Intent(SuccessfulLogin.this, accreditedCourses.class);
                startActivity(intentAccreditedCourses);
            }
        });

        financialAid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to FinAid Portal", Toast.LENGTH_LONG).show();
                Intent intentFinAid = new Intent(SuccessfulLogin.this, financialAid.class);
                startActivity(intentFinAid);
            }
        });
    }
}