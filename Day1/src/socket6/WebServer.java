package socket6;

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
		//找到用户端
		try {
			Socket socket = serverSocket.accept();
			System.out.println("与用户端连接");
			//创建用户处理器
			ClientHandler handler = new ClientHandler(socket);
			//建立线程
			Thread thread = new Thread(handler);
			thread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer webServer = new WebServer();
		webServer.start();
	}
}
