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
}
