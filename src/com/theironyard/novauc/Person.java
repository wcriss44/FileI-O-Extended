package com.theironyard.novauc;

public class Person {

    /*****************
     * Variables
     ****************/

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String ipAddress;

    /*****************
     * Constructors
     ****************/

    public Person(int id, String firstName, String lastName, String email, String country, String ipAddress){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    }
    public Person(){

    }

    /*****************
     * Setters
     ****************/

    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    /*****************
     * Getters
     ****************/

    public String getFirstName(){
        return firstName;
    }
    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getCountry() {
        return country;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    /*********************************
     * toString override for printing
     ********************************/

    @Override
    public String toString(){

        return String.format("%s %s from %s. You can contact at: %s",firstName, lastName, country, email);
    }
}
