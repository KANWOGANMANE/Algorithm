package com.sjq.algrithm;

public class test3 {
    public static void main(String[] args) {
        int nums[] = new int[] {2,1,1,2};
        int [] dp = new int [nums.length];
        int total_max = 0;
        int singal_max = 0;
        for(int i=0;i<nums.length;i++){
            singal_max +=nums[i];
            System.out.print(nums[i]);
            for(int j=i+2;j<nums.length;j++){
                singal_max = singal_max + nums[j];
                System.out.print(nums[j]);
            }
            if(singal_max>total_max){
                total_max = singal_max;
            }
            System.out.println();
            singal_max = 0;
        }
        System.out.println(total_max);
    }
}
