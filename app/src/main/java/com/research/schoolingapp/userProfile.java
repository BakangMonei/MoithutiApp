package com.research.schoolingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.research.schoolingapp.databaseHelper.DBHelper;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class userProfile extends AppCompatActivity {

    private signUp signingUp;
    private final static int REQUEST_CALL=1;
    String email,firstName, lastName,  Gender, Address, Country, IDPassport, DOB, phoneNumber, physicalAdd;

    EditText registerPhoneNumber, registerLastName, registerFirstName, registerDOB, registerGender, registerEmail,
            registerPhysicalAddress, registerPostalAddress, registerIDPass, registerCountry;
    private Uri imageUri;
    private String imageUrl;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);

        Intent userID = getIntent();
        String receivedID = userID.getStringExtra("memberID");

        // TextView
        TextView  surnameView = (TextView) findViewById(R.id.surnameView);
        TextView nameView = (TextView) findViewById(R.id.nameView);
        TextView dateOfBirthView = (TextView) findViewById(R.id.dateOfBirthView);
        TextView emailView= (TextView) findViewById(R.id.emailView);
        TextView genderView = (TextView) findViewById(R.id.genderView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView physicalAddressView= (TextView) findViewById(R.id.physicalAddressView);
        TextView postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        TextView IDPassportView = (TextView) findViewById(R.id.IDPassportView);
        TextView countryView = (TextView) findViewById(R.id.countryView);
        TextView profilePage = (TextView) findViewById(R.id.profilePage);

        ImageView profilePic = (ImageView) findViewById(R.id.profilePic);

        // creating a new dbHelper class and passing our context to it.
        dbHelper = new DBHelper(userProfile.this);

        // EditText
        EditText registerLastName = (EditText) findViewById(R.id.registerLastName);
        EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        EditText registerDOB = (EditText) findViewById(R.id.registerDOB);
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        EditText registerGender = (EditText) findViewById(R.id.registerGender);
        EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        EditText registerPhysicalAddress = (EditText) findViewById(R.id.registerPhysicalAddress);
        EditText registerPostalAddress = (EditText) findViewById(R.id.registerPostalAddress);
        EditText registerIDPass = (EditText) findViewById(R.id.registerIDPass);
        EditText registerCountry = (EditText) findViewById(R.id.registerCountry);
        Button DeleteAccountButton = (Button) findViewById(R.id.DeleteAccountButton);

        signingUp = new signUp(userProfile.this);

        profilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUserDetails(receivedID);
                Intent intent = new Intent(userProfile.this, userProfile.class);
                intent.putExtra("memberID",receivedID);
                startActivity(intent);
            }
        });

        registerPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });

        DeleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Students member = new Students();
                FirebaseDatabase.getInstance().getReference().child("Users").child(member.getEmail()).removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(view.getContext(),"Member Deleted !",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == userProfile.REQUEST_CALL){
        }
        else{
            Toast.makeText(this,"Try Again",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,userProfile.class));
            finish();
        }
    }

    // Delete Account
    private void deleteAccount(){
    }
    // Make phone call
    private void makePhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ registerPhoneNumber.getText().toString()));

        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(userProfile.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }else {
            startActivity(callIntent);
        }
    }

    // onRequestPermissionsResult
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }
        }
    }

    // loadUserDetails
    private void loadUserDetails(String receivedID) {

        FirebaseDatabase.getInstance().getReference().child("Users").child(receivedID)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Students member = snapshot.getValue(Students.class);
                        registerEmail.setText(member.getEmail().toString());
                        registerFirstName.setText(member.getFirstName().toString());
                        registerLastName.setText(member.getLastName().toString());
                        registerDOB.setText(member.getDOB().toString());
                        registerGender.setText(member.getGender().toString());
                        registerPhysicalAddress.setText(member.getAddress().toString());
                        registerPostalAddress.setText(member.getAddress().toString());
                        registerPhoneNumber.setText(member.getPhoneNumber().toString());
                        registerIDPass.setText(member.getIDPassport().toString());
                        registerCountry.setText(member.getCountry().toString());

                        email = member.getEmail();
                        firstName = member.getFirstName();
                        lastName = member.getLastName();
                        Address = member.getAddress();
                        physicalAdd = member.getAddress();
                        Gender = member.getGender();
                        Country = member.getCountry();
                        IDPassport = member.getIDPassport();
                        DOB = member.getDOB();
                        phoneNumber = member.getPhoneNumber();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }
}