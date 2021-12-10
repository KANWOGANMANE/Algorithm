package com.sjq.headfirstjava.simple_dotcomgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numguess = 0;
        SimpleDotcomGame game = new SimpleDotcomGame();
        int randommath = (int) Math.random()*5;
        ArrayList<Integer> list = new ArrayList();
        list.add(randommath);
        list.add(randommath+1);
        list.add(randommath+2);
        game.setter(list);
        boolean isAlive = true;
        Scanner scanner = new Scanner(System.in);
        while(isAlive){
            System.out.print("input a number:");
            String s = scanner.nextLine();
            String result = game.checklocaltion(s);
            numguess++;
            if(result.equals("kill")){
                isAlive=false;
                System.out.println("you toke " + numguess +" times to win!");
            }

        }
    }
}
