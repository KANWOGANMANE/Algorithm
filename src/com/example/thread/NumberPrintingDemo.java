package com.example.thread;

/*
使用线程池的方式创建线程
Executors.newFixedThreadPool
创建两个线程，一个线程打印奇数，另一个线程打印偶数
volatile关键字修饰变量意味着该关键字被一个线程修改，对所有线程可见。
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrintingDemo {
    private static volatile int number = 0;
    private static volatile boolean judge = true;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new Runnable() {

            @Override
            public void run() {
                while(number<=100){
                    if(judge){
                        //偶数线程
                        System.out.println("偶数线程"+number++);
                        judge = false;
                    }
                }

            }
        });

        service.execute(new Runnable() {

            @Override
            public void run() {
                while(number<=100){
                    if(!judge){
                        //技术线程
                        System.out.println("奇数线程"+number++);
                        judge = true;
                    }
                }

            }
        });
        service.shutdown();
    }
}
