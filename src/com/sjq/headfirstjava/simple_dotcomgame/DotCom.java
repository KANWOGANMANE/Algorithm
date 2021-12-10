package com.sjq.headfirstjava.simple_dotcomgame;

import java.util.ArrayList;

public class DotCom {
    private String name;
    private ArrayList<String> locations;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }

    public String checkYourself(String userInput){
        String result = "miss";

        int index = locations.indexOf(userInput);
        if(index>=0){
            locations.remove(index);

            if(locations.isEmpty()){
                result = "kill";
                System.out.println(name + " has been shutdown!");
            }
            result = "hit";
        }
        return result;
    }
}
