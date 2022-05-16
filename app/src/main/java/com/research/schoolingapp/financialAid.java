package com.research.schoolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.databaseHelper.*;
import com.research.schoolingapp.botswanaaccountancycollege.*;

import org.w3c.dom.Text;

public class financialAid extends AppCompatActivity {

    private finAidDBHelper finAidDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financial_aid_activity);

        TextView ApplicationFormView = (TextView) findViewById(R.id.ApplicationFormView);
        TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView physicalAddressView = (TextView) findViewById(R.id.physicalAddressView);
        TextView schoolsOfChoiceTextView = (TextView) findViewById(R.id.schoolsOfChoiceTextView);
        TextView tertiary1 = (TextView) findViewById(R.id.tertiary1);
        TextView tertiary2 = (TextView) findViewById(R.id.tertiary2);

        EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);//
        EditText registerLastName = (EditText) findViewById(R.id.registerLastName);//
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);//
        EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);//
        EditText registerPhysicalAddress = (EditText) findViewById(R.id.registerPhysicalAddress);//
        EditText nameOfInstitution1 = (EditText) findViewById(R.id.nameOfInstitution1);
        EditText nameOfInstitution2 = (EditText) findViewById(R.id.nameOfInstitution2);
        EditText programme1 = (EditText) findViewById(R.id.programme1);
        EditText programme2 = (EditText) findViewById(R.id.programme2);

        Button applyForFinAidBtn = (Button) findViewById(R.id.applyForFinAidBtn);
        finAidDBHelper = new finAidDBHelper(financialAid.this);

        applyForFinAidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String email = registerEmail.getText().toString();
                String phoneNumber = registerPhoneNumber.getText().toString();
                String physicalAddress = registerPhysicalAddress.getText().toString();
                String Institution1 = nameOfInstitution1.getText().toString();
                String Institution2 = nameOfInstitution2.getText().toString();
                String course1 = programme1.getText().toString();
                String course2 = programme2.getText().toString();
                // Validating
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
                if (phoneNumber.isEmpty()) {
                    registerPhoneNumber.setError("Phone-Number is needed!!");
                    registerPhoneNumber.requestFocus();
                    return;
                }
                if (physicalAddress.isEmpty()) {
                    registerPhysicalAddress.setError("Physical address is needed!!");
                    registerPhysicalAddress.requestFocus();
                    return;
                }
                if (Institution1.isEmpty()) {
                    nameOfInstitution1.setError("nameOfInstitution1 is needed!!");
                    nameOfInstitution1.requestFocus();
                    return;
                }
                if (Institution2.isEmpty()) {
                    nameOfInstitution2.setError("nameOfInstitution2 is needed!!");
                    nameOfInstitution2.requestFocus();
                    return;
                }
                if (course1.isEmpty()) {
                    programme1.setError("programme1 is needed!!");
                    programme1.requestFocus();
                    return;
                }
                if (course2.isEmpty()) {
                    programme2.setError("programme2 is needed!!");
                    programme2.requestFocus();
                    return;
                }
                else{
                    finAidDBHelper.newStudentApplications(email, firstName, lastName, physicalAddress, phoneNumber, Institution1, course1, Institution2, course2);
                    // After adding the data we are displaying a toast message.
                    Toast.makeText(financialAid.this, "SuccessfullyApplied", Toast.LENGTH_SHORT).show();

                    registerEmail.setText("");
                    registerFirstName.setText("");
                    registerLastName.setText("");
                    registerPhysicalAddress.setText("");
                    registerPhoneNumber.setText("");
                    nameOfInstitution1.setText("");
                    programme1.setText("");
                    nameOfInstitution2.setText("");
                    programme2.setText("");
                }
            }
        });
    }
}