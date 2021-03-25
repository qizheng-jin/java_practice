package day1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Chatting {
	private ServerSocket serverSocket;
	
	public Server_Chatting() {
		try {
			System.out.println("开始建立服务器");
			serverSocket = new ServerSocket(8088);
			System.out.println("服务器建立完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		//while(true) {
			try {
				Socket socket = serverSocket.accept();
				Client_Chatting cc = new Client_Chatting(socket);
				
				Thread thread = new Thread(cc);
				System.out.println("已经找到用户端");
				thread.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server_Chatting server = new Server_Chatting();
		server.start();
	}

}
