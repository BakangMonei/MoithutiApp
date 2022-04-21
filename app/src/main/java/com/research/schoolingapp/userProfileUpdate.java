package com.research.schoolingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.research.schoolingapp.databaseHelper.DBHelper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;

public class userProfileUpdate extends AppCompatActivity {
    private final static int REQUEST_CALL=1;

    EditText txtFullNames, txtUserName;
    String email,firstName, lastName,  Gender, Address, Country, IDPassport, DOB, phoneNumber, physicalAdd;
    Button btnUpdateUserProfile, btnEditProfilePic;
    EditText registerPhoneNumber, registerLastName, registerFirstName, registerDOB, registerGender, registerEmail,
            registerPhysicalAddress, registerPostalAddress, registerIDPass, registerCountry;
    private Uri imageUri;
    private String imageUrl;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_update_activity);

        Intent userID = getIntent();
        String receivedID = userID.getStringExtra("memberID");

        // TextView
        TextView surnameView = (TextView) findViewById(R.id.surnameView);
        TextView nameView = (TextView) findViewById(R.id.nameView);
        TextView dateOfBirthView = (TextView) findViewById(R.id.dateOfBirthView);
        TextView emailView= (TextView) findViewById(R.id.emailView);
        TextView genderView = (TextView) findViewById(R.id.genderView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView physicalAddressView= (TextView) findViewById(R.id.physicalAddressView);
        TextView postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        TextView IDPassportView = (TextView) findViewById(R.id.IDPassportView);
        TextView countryView = (TextView) findViewById(R.id.countryView);
        TextView profilePage = (TextView) findViewById(R.id.profilePage);

        ImageView profilePic = (ImageView) findViewById(R.id.profilePic);

        // creating a new dbHelper class and passing our context to it.
        dbHelper = new DBHelper(userProfileUpdate.this);

        // EditText
        EditText registerLastName = (EditText) findViewById(R.id.registerLastName);
        EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        EditText registerDOB = (EditText) findViewById(R.id.registerDOB);
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        EditText registerGender = (EditText) findViewById(R.id.registerGender);
        EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        EditText registerPhysicalAddress = (EditText) findViewById(R.id.registerPhysicalAddress);
        EditText registerPostalAddress = (EditText) findViewById(R.id.registerPostalAddress);
        EditText registerIDPass = (EditText) findViewById(R.id.registerIDPass);
        EditText registerCountry = (EditText) findViewById(R.id.registerCountry);

        profilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //updateUserProfile();
            }
        });
    }




}