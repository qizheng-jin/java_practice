package load_static_execise;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	public WebServer() {
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("服务器开始运行");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			Socket socket = serverSocket.accept();
			ClientHandler handler = new ClientHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
			System.out.println("已连接上服务器端");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
		
	}
}
