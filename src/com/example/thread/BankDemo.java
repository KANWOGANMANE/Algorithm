package com.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/*
有一个银行账户里面没有钱
有两个用户对该账户进行存钱，一次存1000分3次进行
 */

public class BankDemo {
    public static void main(String[] args) {
        User account = new User();
        Thread u1 = new Thread(account);
        Thread u2 = new Thread(account);
        u2.start();
        u1.start();
    }
}

class User implements Runnable {
    private int account = 0;
    ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
            for(int  i=0;i<3;++i){
                try {
                lock.lock();
                account+=1000;
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":存钱成功，当前余额为:"+account);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

    }
}
