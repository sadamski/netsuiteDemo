package com.adamtrcka.work.hw.json;

import com.adamtrcka.work.hw.dependency.DependencyStructure;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class jsonReader {

    private String fileName;


    public jsonReader(String fileName) {
        this.fileName = fileName;
        this.parse();
    }

    public void parse() {
        Gson gson = new Gson();
        DependencyStructure ds = new DependencyStructure();

        try {
            File f = new File(String.valueOf(this.getFileFromResource(fileName)));
            JsonReader reader = new JsonReader(new FileReader(f));
            HashMap<String, ArrayList<String>> json = gson.fromJson(reader, HashMap.class);         //this is a large shortcuit to the structure of the JSON file
                                                                                                    //you pass into the HashMap the way the JSON is structure, and pass in the GSON
            for (String key : json.keySet()) {                                                      //a 'for each' loop, for main element in the JSON KEY!
                ArrayList<String> values = json.get(key);
                for (int i = 0; i < values.size(); i++) {                                           //in each element, this traverses 0..N entries in the string array
                    ds.addStructure(key, values.get(i));
                }
            }
            System.out.println("JSON successfully loaded");
            ds.dumpAll();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}
