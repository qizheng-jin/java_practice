package socket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	public WebServer(){
		try {
			System.out.println("开始启动服务器");
			serverSocket = new ServerSocket(8088);
			System.out.println("服务器启动完毕");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			/*
	            http://localhost:8088
	            http://localhost:8088/index.html
           */
			System.out.println("Waiting for connection");
			//启动服务器的语法
			Socket socket = serverSocket.accept();
			System.out.println("One Client server has been connected.");
			//启动一个线程与该客户端交互
			ClientHandler handler = new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}
