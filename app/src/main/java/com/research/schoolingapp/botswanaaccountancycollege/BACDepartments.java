package com.research.schoolingapp.botswanaaccountancycollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.research.schoolingapp.R;
import com.research.schoolingapp.google;

import org.w3c.dom.Text;

public class BACDepartments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bacdepartments_activity);

        TextView BACDepartmentsTextView = (TextView) findViewById(R.id.BACDepartmentsTextView);
        TextView bacTextView = (TextView) findViewById(R.id.bacTextView);
        TextView gaboroneCampusTextView = (TextView) findViewById(R.id.gaboroneCampusTextView);
        TextView francistownCampusTextView = (TextView) findViewById(R.id.francistownCampusTextView);

        Button SCISButton = (Button) findViewById(R.id.SCISButton);
        Button SFPSButton = (Button) findViewById(R.id.SFPSButton);
        Button SBLButton = (Button) findViewById(R.id.SBLButton);
        Button SPSButton = (Button) findViewById(R.id.SPSButton);
        Button ResearchAndInnovationButton = (Button) findViewById(R.id.ResearchAndInnovationButton);
        Button BIISCButton = (Button) findViewById(R.id.BIISCButton);

        SCISButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BACDepartments.this, "Welcome To School Of Computing and Information Systems", Toast.LENGTH_SHORT).show();
                Intent intentSCIS = new Intent(BACDepartments.this, SchoolOfComputingAndInformationSystems.class);
                startActivity(intentSCIS);
            }
        });

        SFPSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BACDepartments.this, "Welcome To School Of Finance And Professional Studies", Toast.LENGTH_SHORT).show();
                Intent intentSFPS = new Intent(BACDepartments.this, SchoolOfFinanceAndProfessionalStudies.class);
                startActivity(intentSFPS);
            }
        });

        SBLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BACDepartments.this, "Welcome To School Of Business And Leisure", Toast.LENGTH_SHORT).show();
                Intent intentSBL = new Intent(BACDepartments.this, SchoolOfBusinessAndLeisure.class);
                startActivity(intentSBL);
            }
        });

        SPSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BACDepartments.this, "Welcome To School Of Post-Graduate Studies", Toast.LENGTH_SHORT).show();
                Intent intentSPS = new Intent(BACDepartments.this, SchoolOfPostGraduateStudies.class);
                startActivity(intentSPS);
            }
        });

        ResearchAndInnovationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BACDepartments.this, "Welcome To Research And Innovation", Toast.LENGTH_SHORT).show();
                Intent intentResearch = new Intent(BACDepartments.this, researchAndInnovation.class);
                startActivity(intentResearch);
            }
        });

        BIISCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BACDepartments.this, "Welcome To Botswana Accountancy College ICT Industry Skills Center", Toast.LENGTH_SHORT).show();
                Intent intentBIISC = new Intent(BACDepartments.this, BIISC.class);
                startActivity(intentBIISC);
            }
        });

    }
}