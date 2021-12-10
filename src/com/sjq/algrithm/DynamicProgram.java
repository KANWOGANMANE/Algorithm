package com.sjq.algrithm;

public class DynamicProgram {
    public static void main(String[] args) {
        int[] array = {
                4,2,8,6,9
        };
        int i = find(array, 0);
        System.out.println(i);
    }
    public static int find(int[] array,int j){
        if(j==array.length-1){
            return 1;
        }
        int max = 1;
        for(int i=j+1;i<array.length;i++){
            if(array[j]<array[i]){
                max = Math.max(max,find(array,i)+1);
            }
        }
        return max;
    }
}
