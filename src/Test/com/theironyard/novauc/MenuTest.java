package com.theironyard.novauc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    Menu menu = new Menu();

    @Test
    public void mainMenu() throws Exception{
        DataRepository<Person> database = new DataRepository<>("Person.csv");
        menu.mainMenu(database);

    }

    @Test
    public void printMenu() throws Exception {

    }

    @Test
    public void checkKey() throws Exception {

    }

    @Test
    public void json() throws Exception {

    }

    @Test
    public void menuDisplay() throws Exception {

    }

}