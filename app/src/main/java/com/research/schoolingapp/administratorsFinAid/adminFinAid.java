package com.research.schoolingapp.administratorsFinAid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.research.schoolingapp.R;
import com.research.schoolingapp.databaseHelper.*;
import com.research.schoolingapp.financingOfStudendets.*;

import java.util.ArrayList;

public class adminFinAid extends AppCompatActivity {
    private studentsApplications SA;
    private DBHelper dbHelper;
    private finAidDBHelper FDB;
    private adminFinAidDatabase AFADB;
    private admin ADMIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminfinaid_activity);

        TextView adminTextView = (TextView) findViewById(R.id.adminTextView);
        TextView StudentApplicationsView = (TextView) findViewById(R.id.StudentApplicationsView);

        Button NextButton = (Button) findViewById(R.id.NextButton);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button ApproveButton = (Button) findViewById(R.id.ApproveButton);

        dbHelper = new DBHelper(adminFinAid.this);
        FDB = new finAidDBHelper(adminFinAid.this);
        AFADB = new adminFinAidDatabase(adminFinAid.this);
        ADMIN = new admin(adminFinAid.this);

        ApproveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(adminFinAid.this, "Successfully Approved", Toast.LENGTH_SHORT).show();
                Intent intentSuccess = new Intent(adminFinAid.this, adminFinAid.class);
                startActivity(intentSuccess);
            }
        });

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentApp = "";
                ArrayList<admin> allApplications = AFADB.readStudentApplicationsAdminFinAid();
                for (admin ap:allApplications){
                    studentApp = studentApp + ap.getEmail() +"\nEmail: ";
                    studentApp = studentApp + ap.getFirstName() +"\nfirstName: ";
                    studentApp = studentApp + ap.getLastName() +"\nlastName: ";
                    studentApp = studentApp + ap.getAddress() +"\nAddress: ";
                    studentApp = studentApp + ap.getPhoneNumber() +"\nphoneNumber:";
                    studentApp = studentApp + ap.getCourse1() +"\nCourse1: ";
                    studentApp = studentApp + ap.getCourse2() +"\nCourse2: ";
                    Toast.makeText(getApplicationContext(),ap.getEmail().toString(),Toast.LENGTH_SHORT).show();
                }

                StudentApplicationsView.setText(studentApp);
            }
        });
    }
}