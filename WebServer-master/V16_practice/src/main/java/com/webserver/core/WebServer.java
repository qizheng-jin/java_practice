package com.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private ServerSocket serverSocket;
    public WebServer(){
        try{
            System.out.println("服务器已经建立");
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try{
            while (true){
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        WebServer server = new WebServer();
        server.start();
    }
}
