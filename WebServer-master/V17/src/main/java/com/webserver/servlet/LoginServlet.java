package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.File;
import java.io.RandomAccessFile;

public class LoginServlet {
    private static final String defaultPath = "./webapps/myweb/";
    public void service(HttpRequest request, HttpResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username is " + username + ", password is " + password);
        if(username == "" || password == ""){
            System.out.println("登录失败！用户名或密码不能为空");
            String path = "login_fail.html";
            File file = new File(defaultPath + path);
            response.setEntity(file);
            return;
        }

        //查找用户名和密码是否在数据文件中
        try(RandomAccessFile raf = new RandomAccessFile("user.dat", "rw")) {
            for(int i=0; i<raf.length()/100; i++){
                raf.seek(i*100);
                byte[] data = new byte[32];
                raf.read(data);
                String name = new String(data, "UTF-8").trim();
                raf.read(data);
                String pin = new String(data, "UTF-8").trim();

                System.out.println("name is " +  name + ", pin is " + pin);
                if(username.equals(name)&&pin.equals(password)){
                    System.out.println("登陆成功");
                    String path = "login_success.html";
                    File file = new File(defaultPath + path);
                    response.setEntity(file);
                    return;
                }
            }
            System.out.println("登录出错，帐号密码不匹配");
            String path = "login_fail.html";
            File file = new File(defaultPath + path);
            response.setEntity(file);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
