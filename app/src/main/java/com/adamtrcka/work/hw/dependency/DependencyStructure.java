package com.adamtrcka.work.hw.dependency;

import java.util.HashMap;
import java.util.TreeMap;

public class DependencyStructure {

    HashMap<String, HashMap> dependOn = new HashMap<>();            //REQ-005 There are actually 2 completely seperate/independant Hash Maps
    HashMap<String, HashMap> depencies = new HashMap<>();           //REQ-004 There are actually 2 completely seperate/independant Hash Maps

    //This method is call in the nested for loops in jsonReader.java, and adds to the above 2 Hashmaps the different data entries -> its called Parent*CHild times
    public void addStructure(String parent, String child) {         

        this.addDependOn(parent, child);
        this.addChild(parent, child);

    }

    //Reverse discovery - main method
    //REQ-005
    private void addDependOn(String parent, String child) {
        HashMap hm = new HashMap();
        if (this.dependOn.containsKey(child)) {
            hm = this.dependOn.get(child);
        }
        hm.put(parent, "is depedant on");
        this.dependOn.put(child, hm);                       //add child 

    }

    private HashMap retParent(String parent) {
        HashMap hm = new HashMap();                         
        if (!this.depencies.containsKey(parent)) {          //checks to see if the parent exists, if not, add parent
            this.depencies.put(parent, hm);
        } else {
            hm = this.depencies.get(parent);                //if is exists, 
        }
        return hm;
    }

    //Forward discovery - main method
    //REQ-004
    private void addChild(String parent, String child) {

        HashMap hm = this.retParent(parent);                //hm is assigned/returned the parent key
        hm.put(child, "is a Child dependancy");             //this parent key has added a child 
        this.depencies.put(parent, hm);                     //put parent to hashmap

    }

    //Main console output dump
    //REQ-007
    public void dumpAll() {
        System.out.println("\n");
        System.out.println("Parent: Forward Dependancy Readout");
        this.depencies.forEach((key, value)
                -> System.out.printf("Key: %s Value: %s \n", key, value)        //a rather messy way of adding carrige returns to the output console
        );
        //System.out.println(this.depencies.toString());
        System.out.println("\n");
        System.out.println("Child Functions: Reverse Dependancy Readout");
        this.dependOn.forEach((key, value)
                -> System.out.printf("Key: %s Value: %s \n", key, value)        //a rather messy way of adding carrige returns to the output console
        );
        System.out.println("\n");
    
    }
    
/*  this code is very simple, however ugly output in the console -> its commented out but kept for debugging 
    public void dumpAll() {
        System.out.println("Parent: Forward Dependancy Readout");
        System.out.println(this.depencies.toString());
        System.out.println(" ");
        
        System.out.println("Child Functions: Reverse Dependancy Readout");
        System.out.println(this.dependOn.toString());
        System.out.println(" ");
        
    }
*/


public boolean isExistsKey(String key)
{
    boolean out = (this.depencies.containsKey(key));
    return out;
}

public boolean isExistsValue(String value)
    {
        boolean out = (this.dependOn.containsKey(value));
        return out;
    }


}
