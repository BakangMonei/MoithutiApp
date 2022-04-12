package com.research.schoolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.botswanaaccountancycollege.*;

import org.w3c.dom.Text;

public class BotswanaAccountancyCollege extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botswana_accountancy_college_activity);

        ImageView bacImageView = (ImageView) findViewById(R.id.bacImageView);

        TextView BACApplyHere = (TextView) findViewById(R.id.BACApplyHere);
        TextView bacTextView = (TextView) findViewById(R.id.bacTextView);
        TextView gaboroneCampusTextView = (TextView) findViewById(R.id.gaboroneCampusTextView);
        TextView francistownCampusTextView = (TextView) findViewById(R.id.francistownCampusTextView);

        Button bacDepartments = (Button) findViewById(R.id.bacDepartments);
        Button aboutBACButton = (Button) findViewById(R.id.aboutBACButton);


        // method to redirect to provided link
        BACApplyHere.setMovementMethod(LinkMovementMethod.getInstance()); // https://thitoacademics.bac.ac.bw/
        // method to change color of the link
        BACApplyHere.setLinkTextColor(Color.BLACK);
        //

        // Buttons
        bacDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BotswanaAccountancyCollege.this, "Welcome to BAC Departments", Toast.LENGTH_LONG).show();
                Intent intentBACDepartments = new Intent(BotswanaAccountancyCollege.this, BACDepartments.class);
                startActivity(intentBACDepartments);
            }
        });

        aboutBACButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BotswanaAccountancyCollege.this, "Know About Us", Toast.LENGTH_LONG).show();
                Intent intentAboutBAC = new Intent(BotswanaAccountancyCollege.this, aboutBAC.class);
                startActivity(intentAboutBAC);
            }
        });

    }
}