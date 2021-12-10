package com.example.serialization;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;

public class pract {
    public static void main(String[] args) throws IOException {
        File f = new File("头条女神第1123期3.jpg.txt");
        FileReader fr = new FileReader(f);
        int n = 0;
        char []ch = new char[8];
        StringBuilder sb =new StringBuilder();
        while((n = fr.read(ch))!=-1){
            for(int i=0;i<n;i++){
                sb.append(ch[i]);
            }
        }
        fr.close();
        System.out.println(sb);
        byte[] decode = Base64.decode(sb.toString());
        File f2 = new File("b.txt");
        FileOutputStream fo = new FileOutputStream(f2);
        int len;
        fo.write(decode);
        fo.close();
















        
        //序列化 先定义文件输出流 然后 绑定到 对象输出流 通过 writeobject方法写
//        FileOutputStream op = new FileOutputStream("mygame.ser");
//        ObjectOutputStream objop = new ObjectOutputStream(op);
//        Integer a =  new Integer(2);
//        objop.writeObject(a);
//        objop.close();

        //反序列化 先定义文件输入流 然后 绑定到 对象输入流 通过 readobject方法读
//        FileInputStream fis = new FileInputStream("mygame.ser");
//        ObjectInputStream ip = new ObjectInputStream(fis);
//        Object o = ip.readObject();
//        Integer a = (Integer)o;
//        System.out.println(a);
    }
}
