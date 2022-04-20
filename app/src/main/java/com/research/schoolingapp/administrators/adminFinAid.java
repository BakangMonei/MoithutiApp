package com.research.schoolingapp.administrators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.R;

import com.research.schoolingapp.databaseHelper.*;
import com.research.schoolingapp.*;
import com.research.schoolingapp.financingOfStudendets.*;

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

            }
        });
    }
}