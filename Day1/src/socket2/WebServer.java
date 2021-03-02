package socket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	public WebServer(){
		try {
			System.out.println("��ʼ����������");
			serverSocket = new ServerSocket(8088);
			System.out.println("�������������");
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
			//�������������﷨
			Socket socket = serverSocket.accept();
			System.out.println("One Client server has been connected.");
			//����һ���߳���ÿͻ��˽���
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
