package socket5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;
	public WebServer() {
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("�������������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		//�ҵ��û�������
		try {
			Socket socket = serverSocket.accept();
			//�����û������������û�������
			ClientHandler handler = new ClientHandler(socket);
			//�����û������������߳�
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
