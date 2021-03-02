import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	
	private ServerSocket serverSocket;
	public WebServer() {
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("创建服务器成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			while(true) {
				System.out.println("等待手机连接");
				Socket socket = serverSocket.accept();
				ClientHandler handler = new ClientHandler(socket);
				Thread thread = new Thread(handler);
				thread.start();
				System.out.println("用户已连接");
			}
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
