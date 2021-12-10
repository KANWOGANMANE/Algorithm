package com.example.collectiondemo;

import java.util.ArrayDeque;

public class DequeDemo {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        stack.push("hello");
        stack.push("world!");
//        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
