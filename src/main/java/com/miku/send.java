package com.miku;

import com.miku.dao.Computer;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;


public class send {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        try {
            //读取配置文件
           BufferedReader bf = new BufferedReader(new FileReader
                   ("G:\\a_Java\\client_demo\\src\\something.properties"));

            prop.load(bf);


            Computer computer = new Computer();
            computer.setFilesrc(new File(prop.getProperty("filesrc")));

            System.out.println("[欢迎使用局域网发送系统,仅支持单文件发送]");
            System.out.println(computer);




            //获取文件
            File file = new File(computer.getFilesrc().toString());
            //文件输入流
            FileInputStream open  = new FileInputStream(file);
            //ip
            Socket socket = new Socket(prop.getProperty("socket1").toString(),10000);


            //创建文件输出流
            FileOutputStream out = (FileOutputStream) socket.getOutputStream();
            //开始传送
            byte[] b = new byte[1024];
            int n = open.read(b);
            while (n != -1) {
                out.write(b, 0, n);
                n = open.read(b);
            }

            //关闭流
            open.close();
            socket.close();
            out.close();
            System.out.println("发送成功");
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }


    }

