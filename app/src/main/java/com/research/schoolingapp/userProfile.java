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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.research.schoolingapp.databaseHelper.DBHelper;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class userProfile extends AppCompatActivity {

    private signUp SU;
    private final static int REQUEST_CALL=1;
    String email,firstName, lastName,  Gender, Address, Country, IDPassport, DOB, phoneNumber, physicalAdd;
    TextView surnameView2, nameView2, dateOfBirthView2, emailView2, genderView2, phoneNumberView2, physicalAddressView2, postalAddressView2, IDPassportView2, countryView2;

    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    private Uri imageUri;
    private String imageUrl;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);

        // Firebase
        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        progressBar = new ProgressBar(this);

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
        TextView  surnameView2 = (TextView) findViewById(R.id.surnameView2);
        TextView nameView2 = (TextView) findViewById(R.id.nameView2);
        TextView dateOfBirthView2 = (TextView) findViewById(R.id.dateOfBirthView2);
        TextView emailView2 = (TextView) findViewById(R.id.emailView2);
        TextView genderView2 = (TextView) findViewById(R.id.genderView2);
        TextView phoneNumberView2 = (TextView) findViewById(R.id.phoneNumberView2);
        TextView physicalAddressView2 = (TextView) findViewById(R.id.physicalAddressView2);
        TextView postalAddressView2 = (TextView) findViewById(R.id.postalAddressView2);
        TextView IDPassportView2 = (TextView) findViewById(R.id.IDPassportView2);
        TextView countryView2 = (TextView) findViewById(R.id.countryView2);

        Button LogOutBtn = (Button) findViewById(R.id.LogOutBtn);
        Button DeleteAccountButton = (Button) findViewById(R.id.DeleteAccountButton);

        // SU = new signUp(userProfile.this);

        // LogOut button
        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogOut = new Intent(userProfile.this, MainActivity.class);
                Toast.makeText(userProfile.this, "Successfully logged out", Toast.LENGTH_SHORT).show();
                startActivity(intentLogOut);
                finish();
            }
        });
        profilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRootRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        Log.d(String.valueOf(userProfile.this), "firstName" + value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Failed to read value
                        Log.w(String.valueOf(userProfile.this), "Failed to read value.", error.toException());
                    }
                });
            }
        });
        phoneNumberView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
        DeleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Students member = new Students();
                FirebaseDatabase.getInstance().getReference().child("Users").child(member.getEmail()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
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

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
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
        deleteAccount();
    }

    // Make phone call
    private void makePhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel: "+ phoneNumberView2.getText().toString()));

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
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                // Member member = snapshot.getValue(Member.class);
                Students  member = snapshot.getValue(Students.class);

                phoneNumber = member.getPhoneNumber();
                emailView2.setText(member.getEmail());
                nameView2.setText(member.getFirstName());
                surnameView2.setText(member.getLastName());
                dateOfBirthView2.setText(member.getDOB());
                genderView2.setText(member.getGender());
                physicalAddressView2.setText(member.getAddress());
                postalAddressView2.setText(member.getAddress());
                phoneNumberView2.setText(member.getPhoneNumber());
                IDPassportView2.setText(member.getIDPassport());
                countryView2.setText(member.getCountry());
            }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }
}