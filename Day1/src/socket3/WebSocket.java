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
			//1. 接受被创建的用户端
			Socket socket = serverSocket.accept();
			//2. 运用客户端处理器，创建线程，连接客户端
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
