package com.theironyard.novauc;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class DataRepository<T> {

    /*****************
     * Variables
     ****************/

    private T t;
    private File file;
    private Scanner scannerFile;
    private FileWriter fileWriter;
    private HashMap<String, ArrayList<Object>> database = new HashMap<>();
    private JsonSerializer serializer = new JsonSerializer();

    /*****************
     * Constructor
     ****************/

    public DataRepository(String filename) throws IOException{
        file = new File(filename);
        scannerFile = new Scanner(file);
        scannerFile.useDelimiter("\n");
    }

    /****************************************
     * Use abstract methods from FI below
     ***************************************/

    public void populateData(FileObjectCreator objectCreator, ObjectKeyMapper keyMapper) {
        while (scannerFile.hasNext()) {
            String nextLine = scannerFile.nextLine();
            Object o = objectCreator.parse(nextLine);
            String key = keyMapper.map(o);
            if (database.containsKey(key)){
                database.get(key).add(o);
            } else {
                database.put(key, new ArrayList<>());
                database.get(key).add(o);
            }

        }
    }
    public void sortData(ObjectSorter objectSorter){
        objectSorter.sortz(database);
    }

    /*****************
     * Print methods
     ****************/


    public void printDatabase(){
        for(ArrayList<Object> o : database.values()) {
            for (Object p : o) {
                System.out.println(p.toString());
            }
        }
    }
    public void printByKey(String key){
        if (database.containsKey(key)){
            for(Object o : database.get(key)){
                System.out.println(o.toString());
            }
        } else {
            System.out.println("Not a valid key! Check first next time!");
        }
    }
    public void printKeySet(){
        for(String s: database.keySet()){
            System.out.println(s);
        }
    }

    /*****************
     * Other methods
     ****************/

    public boolean containsKey(String key){
        return database.containsKey(key);
    }
    public void getJsoned(String filepath) throws IOException{
        fileWriter = new FileWriter(filepath);
        for(ArrayList<Object> o : database.values()){
            for (Object p : o){
                String json = serializer.serialize(p);
                fileWriter.append(json);
                fileWriter.append("\n");
            }
        }
        fileWriter.close();
    }

    /************************
     * Functional Interfaces
     ***********************/

    @FunctionalInterface
    interface ObjectSorter<T>{
        void sortz(HashMap<String, ArrayList> database);
    }
    @FunctionalInterface
    interface FileObjectCreator<T>{
        T parse(String s);
    }
    @FunctionalInterface
    interface ObjectKeyMapper<T>{
        String map(T t);
    }
}
