package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class ChangePinServlet {

    public void service(HttpRequest request, HttpResponse response){
        String username = request.getParameter("username");
        String old_pin = request.getParameter("old_pin");
        String new_pin = request.getParameter("new_pin");
        System.out.println("username is " + username + ", old pin is " + old_pin + ", new_pin is " + new_pin);
    }
}
