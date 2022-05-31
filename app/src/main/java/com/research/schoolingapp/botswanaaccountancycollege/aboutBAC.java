package com.research.schoolingapp.botswanaaccountancycollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.research.schoolingapp.R;


public class aboutBAC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_bac_activity);

        ImageView bacImageView = (ImageView) findViewById(R.id.bacImageView);
        TextView aboutBAcTextView = (TextView) findViewById(R.id.aboutBAcTextView);
        TextView VisionTextView = (TextView) findViewById(R.id.VisionTextView);
        TextView VisionExplainTextView = (TextView) findViewById(R.id.VisionExplainTextView);
        TextView MissionTextView = (TextView) findViewById(R.id.MissionTextView);
        TextView MissionExplainedTextView = (TextView) findViewById(R.id.MissionExplainedTextView);
        TextView ValuesTextView = (TextView) findViewById(R.id.ValuesTextView);
        TextView ValueExplainedTextView = (TextView) findViewById(R.id.ValueExplainedTextView);
        TextView MandateTextView = (TextView) findViewById(R.id.MandateTextView);
        TextView MandateExplainedTextView = (TextView) findViewById(R.id.MandateExplainedTextView);
    }
}