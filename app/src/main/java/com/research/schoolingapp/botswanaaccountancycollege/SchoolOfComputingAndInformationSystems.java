package com.research.schoolingapp.botswanaaccountancycollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.R;
import com.research.schoolingapp.botswanaaccountancycollege.scis.*;

public class SchoolOfComputingAndInformationSystems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scis_activity);

        ImageView DirectorOfSCISImageView = (ImageView) findViewById(R.id.DirectorOfSCISImageView);

        TextView SCISTextView = (TextView) findViewById(R.id.SCISTextView);
        TextView DirectorOfSCISTextView = (TextView) findViewById(R.id.DirectorOfSCISTextView);
        TextView DirectorOfSCISNameTextView = (TextView) findViewById(R.id.DirectorOfSCISNameTextView);
        TextView aboutSCISTextView = (TextView) findViewById(R.id.aboutSCISTextView);

        Button CSEButton = (Button) findViewById(R.id.CSEButton);
        Button BIDAButton = (Button) findViewById(R.id.BIDAButton);

        CSEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SchoolOfComputingAndInformationSystems.this, "Welcome to the Computer Systems Engineering Portal", Toast.LENGTH_SHORT).show();
                Intent intentCSE = new Intent(SchoolOfComputingAndInformationSystems.this, ComputerSystemsEngineering.class);
                startActivity(intentCSE);
            }
        });

        BIDAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SchoolOfComputingAndInformationSystems.this, "Welcome to the Business Intelligence And Data Analytics Portal", Toast.LENGTH_SHORT).show();
                Intent intentBIDA = new Intent(SchoolOfComputingAndInformationSystems.this, BusinessIntelligenceAndDataAnalytics.class);
                startActivity(intentBIDA);
            }
        });
    }
}