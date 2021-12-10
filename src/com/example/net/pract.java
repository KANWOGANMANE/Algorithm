package com.example.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class pract {
    public static void main(String[] args) throws IOException {
        //建立对服务器的连接
        Socket socket = new Socket("127.0.0.1",5000);

        //建立连接到socket上底层输入串流的inputstreamreader
        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());

        //建立buffer来读取
        BufferedReader reader = new BufferedReader(inputStream);
        String msg = reader.readLine();
        System.out.println(msg);
    }
}
