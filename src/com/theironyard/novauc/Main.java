package com.theironyard.novauc;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataRepository<Person> datarepo = new DataRepository<>("people.csv");
        //Person person = new Person();
        datarepo.populateData( (Person -> );

    }
}
