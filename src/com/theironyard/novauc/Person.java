package com.theironyard.novauc;

public class Person {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String country;
    public String ipAddress;

    //TODO: MAKE these private

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
    public String getFirstName(){
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    @Override
    public String toString(){

        return String.format("%s %s from %s. You can contact at: %s",firstName, lastName, country, email);
    }
}
