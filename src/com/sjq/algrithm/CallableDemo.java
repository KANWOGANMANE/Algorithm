package com.sjq.algrithm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
Callable接口相比Runnable：
Callable可以返回参数；
Callable可以抛出异常；
Callable支持泛型；
 */

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=0;i<100;i++){
            if(i%2==0){
                sum+=i;
            }
        }
        return sum;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task t = new Task();
        FutureTask<Integer> task = new FutureTask<Integer>(t);
        new Thread(task).start();
        Integer sum = task.get();
        System.out.println(sum);
    }
}
