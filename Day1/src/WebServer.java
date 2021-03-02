import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 小鸟WebServer
 * 实现Tomcat的基础功能的一个Web容器
 * Web容器的作用：
 * 1：Web容器是一个Web服务端程序，负责与客户端（通常是浏览器）进行交互
 * 2：完成与客户端的TCP连接及数据交互。
 * 3：基于HTTP协议与客户端进行应用交互，是的浏览器可以访问Web容器中部署
 * 的不同网络应用（Webapp）的页面，资源，功能等。
 * 4：可以管理部署多个不同的网络应用。
 */
public class WebServer {
	private ServerSocket serverSocket;
	//建立服务器需要确定服务器端口。
	public WebServer() {
		try {
			System.out.println("ready to run");
			serverSocket = new ServerSocket(8088);
			System.out.println("The socket has started");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//启动服务器
	public void start() {
		try {
			System.out.println("Waiting for connection.");
			Socket socket = serverSocket.accept();
			System.out.println("客户端连接成功！");
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebServer server = new WebServer();
		server.start();
	}

}
