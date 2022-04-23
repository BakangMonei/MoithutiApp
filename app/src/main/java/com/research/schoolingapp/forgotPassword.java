package com.research.schoolingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.research.schoolingapp.databaseHelper.DBHelper;

public class forgotPassword extends AppCompatActivity {

    public DBHelper dbHelper;
    public FirebaseAuth mAuth;
    public DatabaseReference mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);

        TextView forgotPasswordTextView = (TextView) findViewById(R.id.forgotPasswordTextView);
        TextView ChangeEmailView = (TextView) findViewById(R.id.ChangeEmailView);
        TextView newPassword1 = (TextView) findViewById(R.id.newPassword1);
        TextView newPassword2 = (TextView) findViewById(R.id.newPassword2);

        EditText changeEmailEditText = (EditText) findViewById(R.id.changeEmailEditText);
        EditText newPassword1EditText = (EditText) findViewById(R.id.newPassword1EditText);
        EditText newPassword2EditText = (EditText) findViewById(R.id.newPassword2EditText);

        Button changePasswordButton = (Button) findViewById(R.id.changePasswordButton);


        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = changeEmailEditText.getText().toString().trim();
                String pass1 = newPassword1EditText.getText().toString().trim();
                String pass2 = newPassword2EditText.getText().toString().trim();

                // Validation
                if(TextUtils.isEmpty(email) || (TextUtils.isEmpty(pass1)) || (TextUtils.isEmpty(pass2))){
                    Toast.makeText(forgotPassword.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                }
                else if(pass1.length() <= 6){
                    Toast.makeText(forgotPassword.this,"Password is SHORT",Toast.LENGTH_SHORT).show();
                }
                else if(pass2.length() <= 6){
                    Toast.makeText(forgotPassword.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                }
                else if(pass1 == pass2){
                    Toast.makeText(forgotPassword.this,"Passwords do not match",Toast.LENGTH_SHORT).show();
                }
                else{
                    changeForgottenPass(email, pass1, pass2);
                    Toast.makeText(forgotPassword.this, "Password Changed", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void changeForgottenPass(String email, String pass1, String pass2) {
        dbHelper.changeForgottenPass();
    }
}