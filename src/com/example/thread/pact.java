package com.example.thread;

/*
线程代码测试
 */

public class pact {
    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        Thread a = new Thread(window);
        Thread b = new Thread(window);
        Thread c = new Thread(window);
        a.start();
        b.start();
        c.start();
    }
}

class Window implements Runnable {
    int tick = 100;
    @Override
    public void run() {
            while(true){
                synchronized (this){
                if(tick>0){
                    System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+"=>"+tick);
                    tick--;
                }else {
                    break;
                }
                }
            }
        }

}
