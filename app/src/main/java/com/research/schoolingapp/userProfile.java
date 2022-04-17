package com.research.schoolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.databaseHelper.DBHelper;

import java.util.ArrayList;

public class userProfile extends AppCompatActivity {
    private DBHelper dbHelper;
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
        TextView profilePage = (TextView) findViewById(R.id.profilePage);

        // creating a new dbHelper class and passing our context to it.
        dbHelper = new DBHelper(userProfile.this);

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
                String students ="";
                ArrayList<Students> allStudentDetails = dbHelper.readStudents();
                for (Students s : allStudentDetails){
                    students = students + s.getEmail() + "\n";
                    Toast.makeText(getApplicationContext(),s.getEmail().toString(),Toast.LENGTH_SHORT).show();
                }
                registerFirstName.setText(students);
                registerLastName.setText(students);
                registerDOB.setText(students);
                registerEmail.setText(students);
                registerGender.setText(students);
                registerPhoneNumber.setText(students);
                registerPhysicalAddress.setText(students);
                registerPostalAddress.setText(students);
                registerIDPass.setText(students);
                registerCountry.setText(students);
            }
        });
    }
}