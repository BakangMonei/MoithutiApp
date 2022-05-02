package com.research.schoolingapp;

/*
 * Done, left only to write to the database
 * and also to write an algorithm that will check whether all the EditText fields are all filled
 * */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.research.schoolingapp.databaseHelper.DBHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;


public class signUp extends AppCompatActivity{
    // private DBHelper dbHelper;
    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    // public signUp(Context context){}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        progressBar = new ProgressBar(this);


        TextView RegistrationName = (TextView) findViewById(R.id.RegistrationName);
        TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView passwordView = (TextView) findViewById(R.id.passwordView);
        TextView repassView = (TextView) findViewById(R.id.repassView);
        TextView DOBView = (TextView) findViewById(R.id.DOBView);
        TextView genderView = (TextView) findViewById(R.id.genderView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        TextView countryView = (TextView) findViewById(R.id.countryView);
        TextView IDPassportView = (TextView) findViewById(R.id.IDPassportView);

        EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        EditText registerLastName = (EditText) findViewById(R.id.registerLastName);
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        EditText registerPassword = (EditText) findViewById(R.id.registerPassword);
        EditText registerRePass = (EditText) findViewById(R.id.registerRePass);
        EditText registerDOB = (EditText) findViewById(R.id.registerDOB);
        EditText registerGender = (EditText) findViewById(R.id.registerGender);
        EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        EditText registerPostalAddress = (EditText) findViewById(R.id.registerPostalAddress);
        EditText registerCountry = (EditText) findViewById(R.id.registerCountry);
        EditText registerIDPass = (EditText) findViewById(R.id.registerIDPass);

        Button registerButton = (Button) findViewById(R.id.registerButton);
        // dbHelper = new DBHelper(signUp.this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String Password = registerPassword.getText().toString();
                String rePassword = registerRePass.getText().toString();
                String DOB = registerDOB.getText().toString();
                String Gender = registerGender.getText().toString();
                String phoneNumber = registerPhoneNumber.getText().toString();
                String Address = registerPostalAddress.getText().toString();
                String Country = registerCountry.getText().toString();
                String IDPassport = registerIDPass.getText().toString();

                if(TextUtils.isEmpty(email) || (TextUtils.isEmpty(firstName)) || (TextUtils.isEmpty(lastName)) || (TextUtils.isEmpty(Password)) || (TextUtils.isEmpty(rePassword) || (TextUtils.isEmpty(DOB) || (TextUtils.isEmpty(Gender) || (TextUtils.isEmpty(phoneNumber) || (TextUtils.isEmpty(Address) || TextUtils.isEmpty(Country) || TextUtils.isEmpty(IDPassport)))))))
                {
                    Toast.makeText(signUp.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                }
                if(Password.length()<6 || rePassword.length() < 6){
                    Toast.makeText(signUp.this,"Password Too Short !",Toast.LENGTH_SHORT).show();
                }
                if(Password == rePassword && rePassword == Password){
                    Toast.makeText(signUp.this,"Passwords do not match",Toast.LENGTH_SHORT).show();
                }
                else {
                    registerStudent(email, firstName, lastName, Password, rePassword, DOB, Gender, phoneNumber, Address, Country, IDPassport);
                }
            }
        });
    }

    public void registerStudent(String registerEmail, String registerFirstName,
                                String registerLastName, String registerPassword,
                                String registerRePass, String registerDOB,
                                String registerGender, String registerPhoneNumber,
                                String registerPostalAddress, String registerCountry,
                                String registerIDPass){
        progressBar.getProgress();

        mAuth.createUserWithEmailAndPassword(registerEmail,registerPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>(){
            public void onSuccess(AuthResult authResult){
                HashMap<String,Object> map = new HashMap<>();
                map.put("email", registerEmail);
                map.put("firstName", registerFirstName);
                map.put("lastName", registerLastName);
                map.put("Password", registerPassword);
                map.put("RePassword", registerRePass);
                map.put("DOB", registerDOB);
                map.put("Gender", registerGender);
                map.put("phoneNumber", registerPhoneNumber);
                map.put("address", registerPostalAddress);
                map.put("Country", registerCountry);
                map.put("IDPassword", registerIDPass);


                mRootRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>(){
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(signUp.this,"Successfully Registered", Toast.LENGTH_LONG).show();
                                    Intent intent= new Intent(signUp.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(signUp.this,e.getMessage().toString(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}