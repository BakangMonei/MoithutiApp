package com.research.schoolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class userProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);

        // TextView
        TextView  surnameView = (TextView) findViewById(R.id.surnameView);
        TextView nameView = (TextView) findViewById(R.id.nameView);
        TextView dateOfBirthView = (TextView) findViewById(R.id.dateOfBirthView);
        TextView  emailView= (TextView) findViewById(R.id.emailView);
        TextView genderView = (TextView) findViewById(R.id.genderView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView physicalAddressView= (TextView) findViewById(R.id.physicalAddressView);
        TextView postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        TextView IDPassportView = (TextView) findViewById(R.id.IDPassportView);
        TextView countryView = (TextView) findViewById(R.id.countryView);

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
    }
}