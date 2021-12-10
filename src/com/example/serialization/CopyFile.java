package com.example.serialization;


import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
//        File f = new File("1.txt");
//        File f2 = new File("2.txt");
//        copyFileByByte(f,f2);
//        PrintStreamDemo();
        try {
            InsertDataByRandomAccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    通过字节来复制文件
     */
    public static void copyFileByByte(File source, File target){
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try {
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(target);
            bin = new BufferedInputStream(in);
            bout = new BufferedOutputStream(out);
            int len = 0;
            byte [] context = new byte[8];
            //读文件到bin，然后写到bout
            while((len = bin.read(context))!=-1){
                bout.write(context,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bin!=null){
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bout!=null){
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    通过字符来复制文件
     */
    public static void copyFileByChar(File source ,File target){
        BufferedReader bin = null;
        BufferedWriter bout = null;
        try {
            FileReader in = new FileReader(source);
            FileWriter out = new FileWriter(target);
            bin = new BufferedReader(in);
            bout = new BufferedWriter(out);
            int len = 0;
            char [] context = new char[1024];
            while((len = bin.read(context)) != -1){
                bout.write(context, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bin != null){
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bout!=null){
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*
    使用PriteStream输出0-255字节代表的字符
     */
    public static void  PrintStreamDemo(){
        PrintStream psout = null;
        try {
            FileOutputStream fout = new FileOutputStream("ascillchar.txt");
            psout = new PrintStream(fout,true);

            if(psout != null){
                System.setOut(psout);
            }

            for(int i=0;i<=255;i++){
                System.out.print((char)i);
                if(i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            psout.close();
        }
    }

    /*
    通过RandomAccessFile进行对文件内容的插入
    demo：
    abfghi  ->  abcdefghi
     */
    public static void InsertDataByRandomAccess() throws IOException {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("randomaccesstest.txt","rw");
            raf.seek(2);
            //StringBuilder可以换成ByteArrayOutputStream进行存储数据、该对象可以避免出现乱码
            StringBuilder sb = new StringBuilder((int)new File("randomaccesstest.txt").length()); //指定Stringbuilder长度为文件长度
            int len;
            byte [] read  = new byte[1024];
            while((len = raf.read(read)) !=-1){
                sb.append(new String(read,0,len));
            }
            raf.seek(2);//指针指向2位置  开始位置为0
            raf.write("cde".getBytes());
            raf.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(raf != null){
                raf.close();
            }
        }
    }
}



