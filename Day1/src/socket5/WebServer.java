package socket5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	public WebServer() {
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("服务器建立完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		//找到用户服务器
		try {
			Socket socket = serverSocket.accept();
			//根据用户服务器建立用户处理器
			ClientHandler handler = new ClientHandler(socket);
			//根据用户处理器建立线程
			Thread thread = new Thread(handler);
			thread.start();
			System.out.println("Connect to client server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		WebServer webServer = new WebServer();
		webServer.start();
	}
}
