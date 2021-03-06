package httpresponse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;

	public WebServer() {
		try {
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
		WebServer webServer = new WebServer();
		webServer.start();
	}
}
