package socket4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	public WebServer() {
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("Server is ready");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		//找到访问网站的用户
		try {
			Socket socket = serverSocket.accept();
			//创建用户端处理器
			ClientHandler handler = new ClientHandler(socket);
			//为用户端处理器创建线程
			Thread thread = new Thread(handler);
			//线程，冲钅
			thread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebServer webServer = new WebServer();
		webServer.start();
	}

}
