package com.research.schoolingapp.comment;

public class chanpass {
    /* private void changePassword(String registerEmail, String registerPassword, String registerRePass)
    {
        progressBar.getProgress();
        /*mAuth.sendPasswordResetEmail(String registerEmail, registerPassword, registerRePass).addOnSuccessListener(new OnSuccessListener<AuthResult>(){
            public void onSuccess(AuthResult authResult){
                HashMap<String,Object> map = new HashMap<>();
                map.put("email", registerEmail);
                map.put("Password", registerPassword);
                map.put("RePassword", registerRePass);
                map.put("id",mAuth.getCurrentUser().getUid());

                mRootRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>(){
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(signUp.this,"Successfully Changed", Toast.LENGTH_LONG).show();
                                    Intent intent= new Intent(signUp.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                     finish();
                                }
                            }
                        });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(signUp.this,e.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
}*/
}
