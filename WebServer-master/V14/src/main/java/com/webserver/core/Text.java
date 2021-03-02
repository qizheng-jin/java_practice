package com.webserver.core;

public class Text {

    public static void main(String[] args){
        String s = "hello";
        try {
            int a = Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println("!!!");
        }
    }
}
