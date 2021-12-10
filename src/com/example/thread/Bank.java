package com.example.thread;


/*
懒汉式单例线程安全
 */
public class Bank {
    private static Bank instance = null;
    private Bank(){

    }
    public Bank getInstance(){
        if(instance==null){
            synchronized (Bank.class){
                if(instance==null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
