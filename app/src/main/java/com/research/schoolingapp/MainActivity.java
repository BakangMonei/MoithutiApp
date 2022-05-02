package com.research.schoolingapp;

/*
 * 1. Code the login button to get information from database
 * 2. Code the FinAid, Forgot Password and link to the SQLite(Using the update method)
 * 3. Create form for Application of Sponsorship
 * 4. Fix those login buttons for Facebook, Google, Instagram, and twitter with their methods
 * 5. Make userProfile get information for specific student using 'EMAIL' as primary key
 * 6.
 * */
/*
* SignUp firebase done*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.research.schoolingapp.administratorsFinAid.adminFinAid;
import com.research.schoolingapp.administratorsSchool.adminSchool;
import com.research.schoolingapp.databaseHelper.*;
import com.research.schoolingapp.*;

// For linking
import android.content.Intent;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth =FirebaseAuth.getInstance();

        TextView username = (TextView) findViewById(R.id.username); //
        TextView password = (TextView) findViewById(R.id.password); //

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn); // Working
        MaterialButton forgotpass = (MaterialButton) findViewById(R.id.forgotpass); // Working (Layout Left)
        Button sign = (Button) findViewById(R.id.sign); // Working

        ImageButton instasignup = (ImageButton) findViewById(R.id.instasignup);//
        ImageButton twittersignup = (ImageButton) findViewById(R.id.twittersignup);//
        ImageButton fbsignup = (ImageButton) findViewById(R.id.fbsignup);//
        ImageButton googlesignup = (ImageButton) findViewById(R.id.googlesignup);

        dbHelper = new DBHelper(MainActivity.this);


        // admin and ADMIN & Successful LogIn
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = username.getText().toString().trim();
                String txtPassword = password.getText().toString();

                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(MainActivity.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
                }
                if (username.getText().toString().equals("SchoolAdmin@gmail.com") && password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "LOGIN Successful!!!!", Toast.LENGTH_SHORT).show();
                    Intent intentLogIn = new Intent(MainActivity.this, adminSchool.class);
                    startActivity(intentLogIn);
                }

                if (username.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "LOGIN Successful!!!!", Toast.LENGTH_SHORT).show();
                    Intent intentLogIn = new Intent(MainActivity.this, SuccessfulLogin.class);
                    startActivity(intentLogIn);
                }
                if (username.getText().toString().equals("FinAidAdmin@gmail.com") && password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "LOGIN Successful!!!!", Toast.LENGTH_SHORT).show();
                    Intent intentLogInFinAid = new Intent(MainActivity.this, adminFinAid.class);
                    startActivity(intentLogInFinAid);
                }
                else{
                    loginUser(txtEmail,txtPassword);
                }
            }
        });

        // signUpButton

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                Intent intentSignUp = new Intent(MainActivity.this, signUp.class);
                startActivity(intentSignUp);
            }
        });

        // forgotPassword
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password != username){
                    Toast.makeText(MainActivity.this, "Please check your emails password or reset it", Toast.LENGTH_SHORT).show();
                    Intent intentForgotPass = new Intent(MainActivity.this, forgotPassword.class);
                    startActivity(intentForgotPass);
                }
                else{
                    Toast.makeText(MainActivity.this, "Your LogIn initials are OKAY!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // instaSignIn
        instasignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Use your Instagram initials to sign in", Toast.LENGTH_SHORT).show();
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

    private void loginUser(String username, String password){
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(MainActivity.this,"Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, SuccessfulLogin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(MainActivity.this,e.getMessage().toString(),
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}