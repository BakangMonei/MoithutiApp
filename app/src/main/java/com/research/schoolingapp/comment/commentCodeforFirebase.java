package com.research.schoolingapp.comment;

public class commentCodeforFirebase {

    /*public class signUp extends AppCompatActivity implements View.OnClickListener{

    private TextView RegistrationName, firstNameView, lastNameView, emailView, passwordView, DOBView, genderView, phoneNumberView, postalAddressView, countryView, IDPassportView, repassView;
    private EditText registerFirstName, registerLastName, registerEmail, registerPassword, registerDOB, registerGender, registerPhoneNumber, registerPostalAddress, registerCountry, registerIDPass, registerRePass;
    private Button registerButton;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        mAuth = FirebaseAuth.getInstance();

        // So that when we press it, it redirects to home page
        RegistrationName = (TextView) findViewById(R.id.RegistrationName);
        RegistrationName.setOnClickListener(this);

        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);

        // Initializing the EditText Variables
        registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        registerLastName = (EditText) findViewById(R.id.registerLastName);
        registerEmail = (EditText) findViewById(R.id.registerEmail);
        registerPassword = (EditText) findViewById(R.id.registerPassword);
        registerDOB = (EditText) findViewById(R.id.registerDOB);
        registerGender = (EditText) findViewById(R.id.registerGender);
        registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        registerPostalAddress = (EditText) findViewById(R.id.registerPostalAddress);
        registerCountry = (EditText) findViewById(R.id.registerCountry);
        registerIDPass = (EditText) findViewById(R.id.registerIDPass);
        registerRePass = (EditText) findViewById(R.id.registerRePass);

        // Initializing the TextView Variables
        firstNameView = (TextView) findViewById(R.id.firstNameView);
        lastNameView = (TextView) findViewById(R.id.lastNameView);
        emailView  = (TextView) findViewById(R.id.emailView);
        passwordView = (TextView) findViewById(R.id.passwordView);
        DOBView = (TextView) findViewById(R.id.DOBView);
        genderView = (TextView) findViewById(R.id.genderView);
        phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        countryView = (TextView) findViewById(R.id.countryView);
        IDPassportView = (TextView) findViewById(R.id.IDPassportView);
        repassView = (TextView) findViewById(R.id.repassView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.RegistrationName:
                startActivity(new Intent(this, MainActivity.class)); // So that it goes to the homePage/mainMenu
                break;
            case R.id.registerButton:
                registerButton();
                break;
        }
    }

    private void registerButton() {
        // rules soo that the user does not leave the fields empty
        String firstName = registerFirstName.getText().toString().trim();
        String lastName = registerLastName.getText().toString().trim();
        String email = registerEmail.getText().toString().trim();
        String password = registerPassword.getText().toString().trim();
        String reEnterPassword = registerRePass.getText().toString().trim();//
        String dateOfBirth = registerDOB.getText().toString().trim();
        String Gender = registerGender.getText().toString().trim();
        String numberPhone = registerPhoneNumber.getText().toString().trim();
        String address = registerPostalAddress.getText().toString().trim();
        String countryPlace = registerCountry.getText().toString().trim();
        String IDPassport = registerIDPass.getText().toString().trim();

        if (firstName.isEmpty()) {
            registerFirstName.setError("first-name is needed!!");
            registerFirstName.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            registerLastName.setError("last-name is needed!!");
            registerLastName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            registerEmail.setError("email is needed!!");
            registerEmail.requestFocus();
            return;
        }
        // To check whether email address is valid
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            registerEmail.setError("Please provide a valid email!!");
            registerEmail.requestFocus();
            return;
        }//

        if (password.isEmpty()) {
            registerPassword.setError("Password is needed!!");
            registerPassword.requestFocus();
            return;
        }
        // Making an exception since Firebase does not allow a password less than 6 letters
        if (password.length() < 6) {
            registerPassword.setError("Please enter a password more than 7 Characters");
            registerPassword.requestFocus();
            return;
        }//
        if(reEnterPassword.isEmpty()){
            registerRePass.setError("Password is needed");
            registerRePass.requestFocus();
            if(reEnterPassword != password){
                registerRePass.setError("Password does not match first password");
                registerRePass.requestFocus();
                return;
            }//
            else
            return;
        }//
        if(reEnterPassword.length() < 6){
            registerRePass.setError("Please enter a password more than 7 Characters");
            registerRePass.requestFocus();
            return;
        }//
        if (dateOfBirth.isEmpty()) {
            registerDOB.setError("Date of Birth is needed!!");
            registerDOB.requestFocus();
            return;
        }
        if (Gender.isEmpty()) {
            registerGender.setError("Gender is needed!!");
            registerGender.requestFocus();
            return;
        }
        if (numberPhone.isEmpty()) {
            registerPhoneNumber.setError("Phone-Number is needed!!");
            registerPhoneNumber.requestFocus();
            return;
        }
        if (address.isEmpty()) {
            registerPostalAddress.setError("Postal-Address is needed!!");
            registerPostalAddress.requestFocus();
            return;
        }
        if (countryPlace.isEmpty()) {
            registerCountry.setError("Country is needed!!");
            registerCountry.requestFocus();
            return;
        }
        if (IDPassport.isEmpty()) {
            registerIDPass.setError("ID/Passport number is needed!!");
            registerIDPass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Students user = new Students(firstName, lastName, email, Gender, address, countryPlace, IDPassport, dateOfBirth, numberPhone);

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("Users");

                            myRef.setValue("Hello, World!");

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(signUp.this,"User has been registered successfully", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);

                                        // redirect to login layout
                                    }else{
                                        Toast.makeText(signUp.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(signUp.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
*/

    /*loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(MainActivity.this, "LOGIN Successful!!!!", Toast.LENGTH_LONG).show();
                    Intent intentLogIn = new Intent(MainActivity.this, SuccessfulLogin.class);
                    startActivity(intentLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(MainActivity.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();
            }
        });*/

    /*if(repass != password){
                    registerRePass.setError("Password does not match first password");
                    registerRePass.requestFocus();
                    return;
                }//
                else
                    return;*/
    /*if(repass.length() < 6){
                    registerRePass.setError("Please enter a password more than 7 Characters");
                    registerRePass.requestFocus();
                    return;
                }//*/

    /*if (password.length() < 6) {
                    registerPassword.setError("Please enter a password more than 7 Characters");
                    registerPassword.requestFocus();
                    return;
                }//*/
}
