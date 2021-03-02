package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class ChangePinServlet {
    private static final String defaultPath = "./webapps/myweb/";
    public void service(HttpRequest request, HttpResponse response){
        String username = request.getParameter("username");
        String old_pin = request.getParameter("old_pin");
        String new_pin = request.getParameter("new_pin");
        System.out.println("username is " + username + ", old pin is " + old_pin + ", new_pin is " + new_pin);

        //三者都不能为空
        if(username == "" || old_pin == "" || new_pin == ""){
            System.out.println("用户名/旧密码/新密码为空");
            String path = "change_pin_fail.html";
            File file = new File(defaultPath+path);
            response.setEntity(file);
        }

        //比较帐号密码是否正确
        String rightName = "";
        String rightPin = "";
        try(RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");){
            for (int i=0; i<raf.length()/100; i++){
                raf.seek(i*100);
                byte[] data = new byte[32];
                raf.read(data);
                rightName = new String(data, "UTF-8").trim();
                raf.read(data);
                rightPin = new String(data, "UTF-8").trim();
                System.out.println("rightName is " + rightName + ", rightPin is " + rightPin);
                if(rightName.equals(username) && rightPin.equals(old_pin)){
                    System.out.println("帐号密码匹配，准备修改密码");
                    //修改密码
                    raf.seek(i*100+32);
                    data= new_pin.getBytes("UTF-8");
                    data= Arrays.copyOf(data, 32);
                    raf.write(data);
                    String path = "change_pin_success.html";
                    File file = new File(defaultPath + path);
                    response.setEntity(file);
                    System.out.println("修改成功！");
                    return;
                }
            }
            String path = "change_pin_fail.html";
            File file = new File(defaultPath + path);
            response.setEntity(file);
            System.out.println("修改失败，帐号密码不匹配");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
