package com.webserver.servlet;

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Servlet是JAVAEE标准中的一个接口，意思是运行在服务端的小程序
 * 我们用它来处理某个具体请求
 *
 * 当前Servlet用于处理用户注册业务
 */
public class RegServlet {
    private static String defaultPath = "./webapps/myweb/";
    public void service(HttpRequest request, HttpResponse response){
        System.out.println("RegServlet:开始处理用户注册...");
        /*
           1:通过request获取用户在注册页面上输入的注册信息（表单上的信息）
           2：将用户的注册信息写入文件user.dat中
           3：设置response给客户端响应注册结果页面
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String ageStr   = request.getParameter("age");


        if(username=="" || password == "" || nickname == "" || ageStr == "" || !ageStr.matches("[0-9]+")){
            System.out.println("_____________注册错误！");
            String path = "reg_Info_error.html";
            File file = new File(defaultPath + path);
            response.setEntity(file);
            return;
        }
        int age = Integer.parseInt(ageStr);
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {

            System.out.println("注册错误！");
            String path = "reg_Info_error.html";
            File file = new File(defaultPath + path);
            response.setEntity(file);
        }
        System.out.println(username + "," + password + "," + nickname + "," + age);
/*
   2
   每条用户信息占用100字节，其中用户名，密码，昵称为字符串各占32字节，年龄为int值占4字节
 */

        try (RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");) {
            /*
                  先查找用户名是否已经注册完成
             */
            System.out.println("****************************");
            //，每条记录都占100个字节
            for(int i=0; i<raf.length()/100; i++){
                raf.seek(i*100);
                //一条记录占32个字节
                byte[] data = new byte[32];
                raf.read(data); //读取前32个字节
                //raf.write(iterator>>>5);
                String name = new String(data, "UTF-8").trim();
                System.out.println("name is : " + name);
                if(username.equals(name)){
                    System.out.println("该用户名已经注册！");
                    String path = "have_user.html";
                    File file = new File(defaultPath + path);
                    response.setEntity(file);
                    return;
                }

            }






            raf.seek(raf.length());
            byte[] data = username.getBytes("utf-8");
            data = Arrays.copyOf(data, 32);
            raf.write(data);

            data = password.getBytes("utf-8");
            data = Arrays.copyOf(data, 32);
            raf.write(data);

            data = nickname.getBytes("utf-8");
            data = Arrays.copyOf(data, 32);
            raf.write(data);

            raf.writeInt(age);
            System.out.println("注册完毕！");

            //3
            File file = new File("./webapps/myweb/reg_success.html");

            response.setEntity(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("RegServlet:用户注册完毕！");


    }

    private boolean isInt(String str) {
        try {
            int i = Integer.parseInt(str);
            System.out.println("你输入bai的整数du是" + i);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("你输入的不是zhi整数。。。。。。。可能dao是浮点数");
            return false;
        }
    }
}
