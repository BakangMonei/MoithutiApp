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
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

import org.w3c.dom.Text;


public class signUp extends AppCompatActivity{
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

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
        dbHelper = new DBHelper(signUp.this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Below line is to get data from all edit text fields.
                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String email = registerEmail.getText().toString();
                String password = registerPassword.getText().toString();
                String repass = registerRePass.getText().toString();
                String DOB = registerDOB.getText().toString();
                String gender = registerGender.getText().toString();
                String phoneNumber = registerPhoneNumber.getText().toString();
                String address = registerPostalAddress.getText().toString();
                String country = registerCountry.getText().toString();
                String IDPassport = registerIDPass.getText().toString();

                // Validating if the text fields are empty or not.
                if (firstName.isEmpty()) {
                    registerFirstName.setError("first-name is needed!!");
                    registerFirstName.requestFocus();
                    return;
                }
                if (lastName.isEmpty()) {
                    registerLastName.setError("last-name is needed!!");
                    registerLastName.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    registerEmail.setError("email is needed!!");
                    registerEmail.requestFocus();
                    return;
                }
                // To check whether email address is valid
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    registerEmail.setError("Please provide a valid email!!");
                    registerEmail.requestFocus();
                    return;
                }//

                if (password.isEmpty()) {
                    registerPassword.setError("Password is needed!!");
                    registerPassword.requestFocus();
                    return;
                }
                // Making an exception since Firebase does not allow a password less than 6 letters
                if (password.length() < 6) {
                    registerPassword.setError("Please enter a password more than 7 Characters");
                    registerPassword.requestFocus();
                    return;
                }//
                if(repass.isEmpty()){
                    registerRePass.setError("Password is needed");
                    registerRePass.requestFocus();
                    if(repass != password){
                        registerRePass.setError("Password does not match first password");
                        registerRePass.requestFocus();
                        return;
                    }//
                    else
                        return;
                }//
                if(repass.length() < 6){
                    registerRePass.setError("Please enter a password more than 7 Characters");
                    registerRePass.requestFocus();
                    return;
                }//
                if (DOB.isEmpty()) {
                    registerDOB.setError("Date of Birth is needed!!");
                    registerDOB.requestFocus();
                    return;
                }
                if (gender.isEmpty()) {
                    registerGender.setError("Gender is needed!!");
                    registerGender.requestFocus();
                    return;
                }
                if (phoneNumber.isEmpty()) {
                    registerPhoneNumber.setError("Phone-Number is needed!!");
                    registerPhoneNumber.requestFocus();
                    return;
                }
                if (address.isEmpty()) {
                    registerPostalAddress.setError("Postal-Address is needed!!");
                    registerPostalAddress.requestFocus();
                    return;
                }
                if (country.isEmpty()) {
                    registerCountry.setError("Country is needed!!");
                    registerCountry.requestFocus();
                    return;
                }
                if (IDPassport.isEmpty()) {
                    registerIDPass.setError("ID/Passport number is needed!!");
                    registerIDPass.requestFocus();
                    return;
                }

                else{
                    dbHelper.addNewStudent(email, firstName, lastName, gender, address, country, IDPassport, DOB, phoneNumber, password, repass);
                    // After adding the data we are displaying a toast message.
                    Toast.makeText(signUp.this, "Student has been added.", Toast.LENGTH_SHORT).show();

                    registerEmail.setText("");
                    registerFirstName.setText("");
                    registerLastName.setText("");
                    registerGender.setText("");
                    registerPostalAddress.setText("");
                    registerCountry.setText("");
                    registerIDPass.setText("");
                    registerDOB.setText("");
                    registerPhoneNumber.setText("");
                    registerPassword.setText("");
                    registerRePass.setText("");

                }
            }
        });
    }
}
