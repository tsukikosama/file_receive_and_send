package com.miku;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class receive {
    public static void main(String[] args) {
            //处理客户端的请求
            try {
                Properties prop = new Properties();
                    //读取配置文件
                    BufferedReader bf = new BufferedReader(new FileReader
                            ("src/something.properties"));
                    prop.load(bf);
                //接受前文件的准备
                System.out.print("发送");
                File filename = new File(prop.getProperty("filesrc"));
                File target = new File(prop.getProperty("filesrc"));

                if(!target.isFile()){
                    target = new File(target.toString());
                }
                if(target.exists()){
                    target.createNewFile();
                }
                System.out.println("文件输出位置为" + target);
                FileOutputStream save   = new FileOutputStream(target);
                //服务端口
                ServerSocket serve = new ServerSocket(10000);    //服务端口

                //等待客户端的呼叫
                System.out.println("正在等待客户端的呼叫........");
                Socket socket = serve.accept();   //阻塞
                FileInputStream in = (FileInputStream)socket.getInputStream();

                //接收数据
                byte[] b = new byte[64];
                int n = in.read(b);

                while (n != -1) {

                    save.write(b, 0, n);
                    n = in.read(b);
                }
                System.out.println("发送完成");
                socket.close();
                serve.close();
                in.close();
//                save.flush();
                save.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

}
