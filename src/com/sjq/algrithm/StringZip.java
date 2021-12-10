package com.sjq.algrithm;

class StringZip {
    public static void main(String[] args) {
        String[] s = {"adddddds","asdasdffff","zddddfffsddd"};
        for (String a: s){
            String s1 = zipString(a);
            System.out.println(s1);
        }
    }
    public static String zipString(String iniString) {
        // write code here
        char lastchar = 0;
        int lastcharnum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<iniString.length();i++){
            if(i==0){
                lastchar = iniString.charAt(0);
                lastcharnum = 1 ;
                continue;
            }
            char cur = iniString.charAt(i);
            if(cur==lastchar){
                lastcharnum++;
            }else {
                if(lastcharnum==1){
                    sb.append(lastchar);
                }else{sb.append(lastchar).append(lastcharnum);}
                lastchar = cur;
                lastcharnum = 1;
            }
            if(i==iniString.length()-1){
                if(lastcharnum==1){
                    sb.append(lastchar);
                }else{sb.append(lastchar).append(lastcharnum);}
            }
        }
        return sb.length()>iniString.length()?iniString:sb.toString();
    }
}


