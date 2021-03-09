package load_static_files;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	
	public WebServer() {
		try {
			System.out.println("服务器建立完成");
			serverSocket = new ServerSocket(8088);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		while(true) {	
			try {
				Socket socket = serverSocket.accept();
				ClientHandler handler = new ClientHandler(socket);
				Thread thread = new Thread(handler);
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}
