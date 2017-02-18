package com.theironyard.novauc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class DataRepository<T> {
    private T t;
    private File file;
    private Scanner scannerFile;
    private HashMap<String, ArrayList<Object>> database = new HashMap<>();

    public DataRepository(String filename) throws IOException{
        file = new File(filename);
        scannerFile = new Scanner(file);
        scannerFile.useDelimiter("\n");

    }

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

    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }
    @FunctionalInterface
    interface FileObjectCreator<T>{
        T parse(String s);
    }
    @FunctionalInterface
    interface ObjectKeyMapper<T>{
        String map(T t);
    }

    public void printDatabase(){
        for(ArrayList<Object> o : database.values()) {
            for (Object p : o) {
                System.out.println(p.toString());
            }
        }
    }
    public boolean containsKey(String key){
        return database.containsKey(key);
    }
}
