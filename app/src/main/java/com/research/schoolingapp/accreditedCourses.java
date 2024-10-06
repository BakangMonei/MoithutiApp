package com.research.schoolingapp;
// Testing Only
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class accreditedCourses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accredited_courses_activity);

        TextView accreditedCourseTextView = (TextView) findViewById(R.id.accreditedCourseTextView);
        Button listButton = (Button) findViewById(R.id.listButton);

        listButton.setMovementMethod(LinkMovementMethod.getInstance());
    }
};