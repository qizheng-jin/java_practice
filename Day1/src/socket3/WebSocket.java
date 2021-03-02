package socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocket {
	private ServerSocket serverSocket;
	public WebSocket() {
		try {
			System.out.println("ready to create the server socket");
			serverSocket = new ServerSocket(8088);
			System.out.println("Server socket has been created succeessfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		
		try {
			//1. ���ܱ��������û���
			Socket socket = serverSocket.accept();
			//2. ���ÿͻ��˴������������̣߳����ӿͻ���
			ClientHandler handler = new ClientHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebSocket socket = new WebSocket();
		socket.start();
	}
}
