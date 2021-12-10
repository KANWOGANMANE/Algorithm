package com.sjq.algrithm;

public class practice {
    public static void main(String[] args) {
        char [] chars = {'a','a','c','b','b','d','s','e','e'};
        int compress = compress(chars);

        System.out.println(compress);
    }

    public static int compress(char[] chars) {
        char lastchar = 0;
        int lastcharnum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++) {
            if(i==0){
                lastchar = chars[0];
                lastcharnum = 1;
                continue;
            }

            if(lastchar == chars[i]){
                lastcharnum++;
            }
            else{
                if(lastcharnum == 1){
                    sb.append(lastchar);
                    lastchar = chars[i];
                    lastcharnum = 1;
                }else{
                    sb.append(lastchar).append(lastcharnum);
                    lastchar = chars[i];
                    lastcharnum = 1;
                }
            }

            if(i==chars.length-1){
                if(lastcharnum==1){
                    sb.append(lastchar);
                }else {
                    sb.append(lastchar).append(lastcharnum);
                }
            }
        }
        char c [] = sb.toString().toCharArray();
        System.out.println(c);
        return c.length>chars.length ?chars.length :c.length;
    }
}
