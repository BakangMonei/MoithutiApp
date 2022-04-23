package com.research.schoolingapp.forgetPass;

import android.content.Context;

import javax.crypto.EncryptedPrivateKeyInfo;

public class changePass {
    // Attributes
    public String password1, password2, emailChange;

    // Empty constructor
    public changePass(Context context){

    }

    // Constructors
    public changePass(String password1, String password2, String emailChange) {
        this.password1 = password1;
        this.password2 = password2;
        this.emailChange = emailChange;
    }

    // Getters
    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public String getEmailChange() {
        return emailChange;
    }

    // Setters

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setEmailChange(String emailChange) {
        this.emailChange = emailChange;
    }
}
