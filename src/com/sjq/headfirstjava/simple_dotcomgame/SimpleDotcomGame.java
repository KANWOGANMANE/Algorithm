package com.sjq.headfirstjava.simple_dotcomgame;

import java.util.ArrayList;

public class SimpleDotcomGame {
    private ArrayList<Integer> location;
    private int bingo = 0;

    public  void setter(ArrayList<Integer> lo){
        location = lo;
    }

    public String checklocaltion(String guess){
        int gueint = Integer.parseInt(guess);
        String result = "miss";

        int index = location.indexOf(gueint);
        if(index >= 0){
            result = "hit";
            System.out.println("hit");
            location.remove(index);
            if(location.isEmpty()){
                result = "kill";
                System.out.println("kill");
                return result;
            }
            return result;
        }
        System.out.println("miss");
        return result;
    }

}
