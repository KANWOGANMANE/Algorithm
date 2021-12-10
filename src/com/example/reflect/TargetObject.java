package com.example.reflect;

public class TargetObject {
    private String value;
    public TargetObject(){
        value = "SJQ Java Reflect Practice";
    }

    private void privateMethod(){
        System.out.println("privateMethod=>" + value);
    }

    public void publicMethod(String s){
        System.out.println("publicMethod=>" + s);
    }
}
