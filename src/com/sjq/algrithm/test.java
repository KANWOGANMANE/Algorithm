package com.sjq.algrithm;

public class test {
    public static void main(String[] args) {
        Integer a = 111;
        Integer b = 111;

        Integer c = 255;
        Integer d = 255;
        System.out.println(a==b);
        System.out.println(c==d);

//        int a [] = {5,5,10,10,20};
//        lemonadeChange(a);
    }

    public static void faiode(String a){
        a ="welocome";
    }


    public static boolean lemonadeChange(int[] bills) {
        int sum = 0;
        if(bills[0]==5){
            sum=sum+5;
        }else {
            return false;
        }
        for(int i=1;i<bills.length;i++){
            if(bills[i]<=sum){
                sum=sum + 5;
            }else{
                return false;
            }
        }
        return true;
    }
}
