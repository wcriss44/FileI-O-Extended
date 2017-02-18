package com.theironyard.novauc;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataRepositoryTest {
    @Test
    public void populateData() throws Exception {
        DataRepository<Person> database = new DataRepository<>("people.csv");

        DataRepository.FileObjectCreator<Person> createObject = p -> {
            String[] nextArr = p.split(",");
            return  new Person (Integer.valueOf(nextArr[0]), nextArr[1], nextArr[2], nextArr[3], nextArr[4], nextArr[5]);
        };

        DataRepository.ObjectKeyMapper<Person> mapKey = p ->  p.getCountry();

        database.populateData(createObject, mapKey);
        assertTrue(database.containsKey("United States"));

    }

}