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
		//�ҵ�������վ���û�
		try {
			Socket socket = serverSocket.accept();
			//�����û��˴�����
			ClientHandler handler = new ClientHandler(socket);
			//Ϊ�û��˴����������߳�
			Thread thread = new Thread(handler);
			//�̣߳�����
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
