package com.sjq.algrithm.dfs;

public class abc {
    public static void main(String[] args) {
        String  str= "abc";
        char [] res = new char[3];
        method(str.toCharArray(),res,1);
    }

    public static void method(char [] c,char [] res,int len){
        if(len==c.length+1){
            System.out.println(res);
            return;
        }

        for(int i=0;i<c.length;i++){
            char tmp = c[i];
            if(c[i]!='`'){
                res[i]=c[i];
                c[i]='`';
                method(c,res,len+1);
                c[i]=tmp;
                res[i]=' ';
            }
        }


    }
}
