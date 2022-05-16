package com.research.schoolingapp.botswanaaccountancycollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.R;
import com.research.schoolingapp.databaseHelper.finAidDBHelper;
import com.research.schoolingapp.databaseHelper.schoolDBHelper;
import com.research.schoolingapp.financialAid;

import org.w3c.dom.Text;

public class applyHereBAC extends AppCompatActivity {

    private schoolDBHelper schooldbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_here_bac_activity);

        TextView ApplicationFormView = (TextView) findViewById(R.id.ApplicationFormView);
        TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView physicalAddressView = (TextView) findViewById(R.id.physicalAddressView);
        TextView pointsTextView = (TextView) findViewById(R.id.pointsTextView);
        TextView courseOfChoiceTextView = (TextView) findViewById(R.id.courseOfChoiceTextView);
        TextView tertiary1 = (TextView) findViewById(R.id.tertiary1);
        TextView tertiary2 = (TextView) findViewById(R.id.tertiary2);

        EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        EditText registerLastName = (EditText) findViewById(R.id.registerLastName);
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        EditText registerPhysicalAddress = (EditText) findViewById(R.id.registerPhysicalAddress);
        EditText pointsEditText = (EditText) findViewById(R.id.pointsEditText);
        EditText nameOfCourse1 = (EditText) findViewById(R.id.nameOfCourse1);
        EditText nameOfCourse2 = (EditText) findViewById(R.id.nameOfCourse2);

        Button applyForSchoolBtn = (Button) findViewById(R.id.applyForSchoolBtn);
        schooldbhelper = new schoolDBHelper(applyHereBAC.this);

        applyForSchoolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String email = registerEmail.getText().toString();
                String phoneNumber = registerPhoneNumber.getText().toString();
                String physicalAddress = registerPhysicalAddress.getText().toString();
                String Points = pointsEditText.getText().toString();
                String course1 = nameOfCourse1.getText().toString();
                String course2 = nameOfCourse2.getText().toString();
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
                if (Points.isEmpty()) {
                    pointsEditText.setError("nameOfInstitution2 is needed!!");
                    pointsEditText.requestFocus();
                    return;
                }
                if (course1.isEmpty()) {
                    nameOfCourse1.setError("programme1 is needed!!");
                    nameOfCourse1.requestFocus();
                    return;
                }
                if (course2.isEmpty()) {
                    nameOfCourse2.setError("programme2 is needed!!");
                    nameOfCourse2.requestFocus();
                    return;
                }
                else{
                    schooldbhelper.newStudentSchoolApplications(email, firstName, lastName, physicalAddress, phoneNumber, Points, course1, course2);
                    // After adding the data we are displaying a toast message.
                    Toast.makeText(applyHereBAC.this, "Student has been added.", Toast.LENGTH_SHORT).show();

                    registerEmail.setText("");
                    registerFirstName.setText("");
                    registerLastName.setText("");
                    registerPhysicalAddress.setText("");
                    registerPhoneNumber.setText("");
                    pointsEditText.setText("");
                    nameOfCourse1.setText("");
                    nameOfCourse2.setText("");
                }
            }
        });
    }

}