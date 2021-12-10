package com.sjq.algrithm;

public class Manacher {
    public static void main(String[] args) {
        String s = "cbbddacbabcade";
        String s2 = "*#c#b#b#d#d#a#c#b#a#b#c#a#d#e#*";
        int len = s.length();
        int lenpro = s2.length();//加了#后的字符串长度
        char [] chars = s.toCharArray();//原字符串转化成char数组
        char [] charspro = new char[lenpro];//用于存放+了#号的字符串
        charspro = s2.toCharArray();
        int index = 0;

        int [] p = new int[lenpro];//辅助数组，记录以i为中心的最长回文串的半径
        int maxRight = 0 ,maxCenter = 0;//maxRight和maxCenter可以计算出该回文串的位置
        //maxRight是以maxCenter为中心的最长回文串的右边界索引----->左边界索引为 maxLeft = 2*maxCenter-maxRight
        int resCenter = 0,resLen = 0;//记录遍历过的最大回文串的中心下标和半径
        //遍历数组res
        for(int i=0;i<lenpro;i++){
            p[i] = maxRight>i?Math.min(p[maxCenter*2-i],p[maxRight-i]) : 1;
            while(i-p[i]>=0 && i+p[i]<lenpro && charspro[i-p[i]]==charspro[i+p[i]]){
                p[i]++;
            }
            //-------------------------------------------------------------------------------------
            //中心在最大右边界内
//            if(i<maxRight){
//                //i中心+右边长度在最大右边界内
//                if(p[maxCenter*2-i]<maxRight-i){//maxRight-i相当于以i为中心的回文串在 maxcenter为中心的回文串里面
//                    p[i] = p[maxCenter*2-i];//p[maxCenter*2-i]就是于以maxcenter为对称中心i的位置
//                }else {
//                    //以i为中心的回文串不在maxcenter的回文串里面   先要把里面的和外面的加起来
//                    p[i] = p[maxRight-i];
//                    while(i-p[i]>=0 && i+p[i]<lenpro && charspro[i-p[i]]==charspro[i+p[i]]){
//                        p[i]++;
//                    }
//                }
//            }else{
//                //直接以i为中心进行扩散
//                p[i] = 1;
//                while(i-p[i]>=0 && i+p[i]<lenpro && charspro[i-p[i]]==charspro[i+p[i]]){
//                    p[i]++;
//                }
//            }
            //-------------------------------------------------------------------------------------
            //如果以i为中心半径为
            if(i+p[i]>maxRight){
                maxRight = i+p[i];
                maxCenter = i;
            }

            if(p[i]>resLen){
                resLen = p[i];
                resCenter = i;
            }
        }
        int start = (resCenter-resLen) / 2;
        System.out.println(s.substring(start,resLen));
    }
}
