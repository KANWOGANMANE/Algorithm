package com.sjq.algrithm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
        String s = " ddffsd ";
        System.out.println(myTrim(s));

    }

    public static String myTrim(String str) {
        if (str != null) {
            int start = 0;// 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1;// 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            System.out.println("start" + start);

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            System.out.println("end" + end);
            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end+1);
        }
        return null;
    }

}
