package com.sjq.algrithm;

//原字符串长度为p[i]-1
//p[i]*2-1 等于 回文字符串+# 的长度

public class Manacher {
//    public static void main(String[] args) {
//        String s = "babad";
//        int len = s.length();
//        int lenpro = len*2+1;//加了#后的字符串长度
//        char [] chars = s.toCharArray();//原字符串转化成char数组
//        char [] charspro = new char[lenpro];//用于存放+了#号的字符串
//
//        int index = 0;
//        for(int i=0;i<lenpro;i++){
//            charspro[i] = i%2==0? '#' : chars[index++];
//        }
//        for(int i=0;i<lenpro;i++){
//            System.out.print(i+ " ");
//        }
//        System.out.println();
//
//        for(int i=0;i<lenpro;i++){
//            System.out.print(charspro[i]+ " ");
//        }
//        System.out.println();
//
//
//        int [] p = new int[lenpro];//辅助数组，记录以i为中心的最长回文串的半径
//        int maxRight = 0 ,maxCenter = 0;//maxRight和maxCenter可以计算出该回文串的位置
//        //maxRight是以maxCenter为中心的最长回文串的右边界索引----->左边界索引为 maxLeft = 2*maxCenter-maxRight
//        int resCenter = 0,resLen = 0;//记录遍历过的最大回文串的中心下标和半径
//        //遍历数组res
//        for(int i=0;i<lenpro;i++){
//            //中心在最大右边界内
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
//
//            //如果以i为中心半径为
//            if(i+p[i]>maxRight){
//                maxRight = i+p[i];
//                maxCenter = i;
//            }
//
//            if(p[i]>resLen){
//                resLen = p[i];
//                resCenter = i;
//            }
//        }
//
//        for(int i=0;i<p.length;i++){
//            System.out.print(p[i]+ " ");
//        }
//        System.out.println();
//        System.out.println(resCenter-resLen);
//        System.out.println((resCenter-resLen)>>1);
//        System.out.println(resLen-1);
//        System.out.println(s.substring((resCenter-resLen)>>1,resLen-1));
//    }
public static void main(String[] args) {
    String s = "babad";
    int len = s.length();
    int lenpro = len*2+1;
    char [] chars = s.toCharArray();
    char [] charspro = new char[lenpro];
    int index = 0;
    for(int i=0;i<lenpro;i++){
        charspro[i] = i%2==0 ? '#' : chars[index++];
    }

    int maxcenter = 0,maxright = 0;
    int rescenter = 0,reslen = 0;
    int [] p = new int [lenpro];
    for(int i=0;i<lenpro;i++){
        if(i<maxright){
            if(p[maxcenter*2-i]<maxright-i){
                p[i] = p[maxcenter*2-i];
            }else{
                p[i]=maxright-i;
                while(i-p[i]>=0 && i+p[i]<lenpro && charspro[i-p[i]]==charspro[i+p[i]]){
                    p[i]++;
                }
            }
        }else{
            p[i]=1;
            while(i-p[i]>=0 && i+p[i]<lenpro && charspro[i-p[i]]==charspro[i+p[i]]){
                p[i]++;
            }
        }

        if(i+p[i]>maxright){
            maxcenter = i;
            maxright = p[i]+i;
        }
        if(p[i]>reslen){
            reslen = p[i];
            rescenter = i;
        }

    }
    int start = (rescenter - reslen) >> 1;
    //截取最长回文子串
    System.out.println(s.substring(start+1, start+1 + reslen));;
}
}
