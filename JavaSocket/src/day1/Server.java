package day1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * 代表Socket的服务器端--利用ServerSocket
 *
 */
public class Server {
	public ServerSocket serverSocket;
	public Server() {
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("服务器创建完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		InputStream in = null;
		try {
			Socket socket = serverSocket.accept();
			System.out.println("客户端已连接");
			in = socket.getInputStream();
			int d;
			char cur = ' ';
			char pre = ' ';
			
			while((d=in.read())!=-1) {
				System.out.print((char)d);
				cur = (char)d;
				if(cur=='m') break;
				pre = cur;
			}
			
			OutputStream out = socket.getOutputStream();
			System.out.println("服务器开始写入");
			Scanner scan = new Scanner(System.in);
			String line = scan.nextLine();
			byte[] data = line.getBytes();
			out.write(data);
			out.flush();
			System.out.println("服务器写入完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
