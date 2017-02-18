package com.theironyard.novauc;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataRepository<Person> datarepo = new DataRepository<>("people.csv");

        /*****************************************************************
         * First Lambda expression.
         * This changes the behavior of ObjectKeyMapper, which is
         * a functional interface declared in DataRepository class.
         * This lambda expression forces a Person type class to be passed
         * and expects a Person object as a parameter. It then returns the
         * getCountry() method from this passed object.
         *****************************************************************/

        DataRepository.ObjectKeyMapper<Person> mapKey = p ->  p.getCountry();


        /*******************************************************************
         * Second Lambda expression
         * This changes the behavior of FileObjectCreator. It explicitly requires
         * a Person object as the return type and a String as the parameter.
         * It splits the passed in string with a comma regex and returns a new
         * Person object created from the resulting String Array.
         *******************************************************************/

        DataRepository.FileObjectCreator<Person> createObject = p -> {
            String[] nextArr = p.split(",");
            return  new Person (Integer.valueOf(nextArr[0]), nextArr[1], nextArr[2], nextArr[3], nextArr[4], nextArr[5]);
        };

        datarepo.populateData(createObject, mapKey);
    }
}
