package com.research.schoolingapp;

public class User {
    // Attributes
    public String firstName, lastName, email,  Gender, address, countryPlace, IDPassport, dateOfBirth, numberPhone;

    // Empty constructors
    public User() {

    }

    // Constructors
    public User(String firstName, String lastName, String email,  String gender, String address, String countryPlace, String IDPassport, String dateOfBirth, String numberPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.Gender = gender;
        this.address = address;
        this.countryPlace = countryPlace;
        this.IDPassport = IDPassport;
        this.dateOfBirth = dateOfBirth;
        this.numberPhone = numberPhone;
    }


    // Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCountryPlace() {
        return countryPlace;
    }

    public String getIDPassport() {
        return IDPassport;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    // Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountryPlace(String countryPlace) {
        this.countryPlace = countryPlace;
    }

    public void setIDPassport(String IDPassport) {
        this.IDPassport = IDPassport;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
