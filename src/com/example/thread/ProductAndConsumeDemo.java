package com.example.thread;

/*
生产者和消费者练习
生产者生成产品当生产到20就停止生产，继续消费
消费者消费产品当消费没有的时候就停止消费,继续生产
ps:wait()、notify()、notify()调用的对象是同步代码块或同步方法的监视器
 */

class Consumer implements Runnable {
    private clerk cl;

    Consumer(clerk cl){
        this.cl = cl;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cl.consumeProduct();
        }
    }
}

class Producter implements Runnable {
    private clerk cl;

    Producter(clerk cl){
        this.cl = cl;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cl.productProduct();
        }
    }
}

class clerk {
    private int productCount = 0;

    public synchronized void productProduct() {

        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：正在生产产品现在有" + productCount);
            notify();
        } else {
            //阻塞线程
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumeProduct() {
        if (productCount > 0) {
            productCount--;
            System.out.println(Thread.currentThread().getName() + "：正在消耗产品现在有" + productCount);
            notify();
        } else {
            //阻塞线程
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ProductAndConsumeDemo {
    public static void main(String[] args) {
        clerk cl = new clerk();
        Consumer c = new Consumer(cl);
        Producter p = new Producter(cl);
        Thread producter = new Thread(p);
        Thread consumer = new Thread(c);
        Thread consumer2 = new Thread(c);
        producter.setName("生产者");
        consumer.setName("消费者");
        consumer2.setName("消费者2");
        producter.start();
        consumer.start();
        consumer2.start();
    }
}
