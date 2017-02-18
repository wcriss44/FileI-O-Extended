package com.theironyard.novauc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Menu {
    /*******************************
     * Lambda expression for sorting
     *******************************/
    DataRepository.ObjectSorter<Person> sorter = p -> {
        for (ArrayList<Person> o : p.values()) {
            o.sort(Comparator.comparing(o1 -> o1.getLastName()));
        }
    };

    /***********************
     * Menus
     **********************/

    public void mainMenu(DataRepository<Person> dataRepository) throws IOException{
        menuDisplay();
        while(true){
            System.out.println("[Check Key][Sort][Print Menu][JSON][Exit]");
            switch(BigData.scanner.nextLine().toUpperCase()){
                case "CHECK KEY":
                case "CHECKKEY":
                    checkKey(dataRepository);
                    break;
                case "SORT":
                    dataRepository.sortData(sorter);
                    break;
                case "PRINT MENU":
                    printMenu(dataRepository);
                    break;
                case "JSON":
                    dataRepository.getJsoned(json() + ".json");
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid choice!");
                    break;
            }
        }
    }
    public void printMenu(DataRepository<Person> dataRepository){
        while(true){
            System.out.println("Welcome to print menu! Choose one: ");
            System.out.println("[Key Set][Entries by Key][All Entries][Return]");
            switch(BigData.scanner.nextLine().toUpperCase()){
                case "KEY SET":
                case "KEYSET":
                    dataRepository.printKeySet();
                    break;
                case "ENTRIES BY KEY":
                case "ENTRIESBYKEY":
                    System.out.println("Key to query: ");
                    dataRepository.printByKey(BigData.scanner.nextLine());
                    break;
                case "ALL ENTRIES":
                case "ALLENTRIES":
                    dataRepository.printDatabase();
                    break;
                case "RETURN":
                    return;
                default:
                    System.out.println("Please enter a valid choice!");

            }
        }
    }

    /***********************
     * Other methods
     **********************/

    public void checkKey(DataRepository<Person> dataRepository){
        System.out.println("Key to check: ");
        if (dataRepository.containsKey(BigData.scanner.nextLine())){
            System.out.println("Key Found!");
        } else {
            System.out.println("NO Key Found!");
        }
    }
    public String json(){
        System.out.println("This will create a JSON file for you! Please choose a name for it.\n");
        System.out.print("Name for JSON file: ");
        return BigData.scanner.nextLine();
    }
    public void menuDisplay(){
        System.out.println("****************************************");
        System.out.println("*            Database 4.0.2            *");
        System.out.println("*  Llamas, abstracted and interfaced!  *");
        System.out.println("*            JSONed for fun!           *");
        System.out.println("*                                      *");
        System.out.println("****************************************\n");
    }

}
