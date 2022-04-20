package com.research.schoolingapp.administrators;

import android.content.Context;

public class admin {
    // Attributes
    public String email, firstName, lastName, address, phoneNumber, institute1, course1, institute2, course2;

    // Empty constructors
    public admin(){
    }

    // Constructors
    public admin(String email, String firstName, String lastName, String address, String phoneNumber, String institute1, String course1, String institute2, String course2) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.institute1 = institute1;
        this.course1 = course1;
        this.institute2 = institute2;
        this.course2 = course2;
    }

    public admin(Context context) {
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInstitute1() {
        return institute1;
    }

    public String getCourse1() {
        return course1;
    }

    public String getInstitute2() {
        return institute2;
    }

    public String getCourse2() {
        return course2;
    }

    // Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInstitute1(String institute1) {
        this.institute1 = institute1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public void setInstitute2(String institute2) {
        this.institute2 = institute2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }
}
