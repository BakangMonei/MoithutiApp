package com.research.schoolingapp.administratorsSchool;

import android.content.Context;

public class studentsApplicationsSchool {
    // Attributes
    public String email,firstName, lastName, Address,phoneNumber, Points, course1, course2;

    // Constructors
    public studentsApplicationsSchool(){

    }

    //Constructors
    public studentsApplicationsSchool(String email, String firstName, String lastName, String address, String phoneNumber, String points, String course1, String course2) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.phoneNumber = phoneNumber;
        Points = points;
        this.course1 = course1;
        this.course2 = course2;
    }

    public studentsApplicationsSchool(Context context) {
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
        return Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPoints() {
        return Points;
    }

    public String getCourse1() {
        return course1;
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
        Address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPoints(String points) {
        Points = points;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }


}
