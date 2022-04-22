package com.research.schoolingapp.administratorsSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.research.schoolingapp.R;

import java.lang.reflect.Member;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.research.schoolingapp.Students;
import com.research.schoolingapp.databaseHelper.DBHelper;
import com.research.schoolingapp.databaseHelper.schoolDBHelper;
import com.research.schoolingapp.signUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class adminSchool extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public schoolDBHelper schooldbHelper;
    private DatabaseReference mRootRef;
    public studentsApplicationsSchool SAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_school_activity);

        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();

        schooldbHelper = new schoolDBHelper(adminSchool.this);

        TextView StudentsApplicationsTextView = (TextView) findViewById(R.id.StudentsApplicationsTextView);
        TextView ViewRequest = (TextView) findViewById(R.id.ViewRequest);

        Button delBtn = (Button) findViewById(R.id.delBtn);
        Button addNewBtn = (Button) findViewById(R.id.addNewBtn);
        Button updateBtn = (Button) findViewById(R.id.delBtn);
        Button nextBtn = (Button) findViewById(R.id.nextBtn);

        SAS = new studentsApplicationsSchool(adminSchool.this);


        // NextButton
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentApp = "";
                ArrayList<studentsApplicationsSchool> allApplications = schooldbHelper.readStudentApplications();
                for (studentsApplicationsSchool ap:allApplications){
                    studentApp = studentApp + ap.getEmail() +"\nEmail: ";
                    studentApp = studentApp + ap.getFirstName() +"\nfirstName: ";
                    studentApp = studentApp + ap.getLastName() +"\nlastName: ";
                    studentApp = studentApp + ap.getAddress() +"\nAddress: ";
                    studentApp = studentApp + ap.getPoints() +"\nPoints Taken: ";
                    studentApp = studentApp + ap.getPhoneNumber() +"\nphoneNumber:";
                    studentApp = studentApp + ap.getCourse1() +"\nCourse1: ";
                    studentApp = studentApp + ap.getCourse2() +"\nCourse2: ";
                    Toast.makeText(getApplicationContext(),ap.getEmail().toString(),Toast.LENGTH_SHORT).show();
                }

                ViewRequest.setText(studentApp);
            }
        });

        // New Student button
        addNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(adminSchool.this, "Add new student Applications", Toast.LENGTH_SHORT).show();
                Intent intentAddStuApp = new Intent(adminSchool.this, addStuSchool.class);
                startActivity(intentAddStuApp);
            }
        });

        // Update records button
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schooldbHelper.updateStudentSchoolApplication();
            }
        });

        // Delete button
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schooldbHelper.deleteStudentSchoolApplication();
            }
        });
    }


}