package java_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	ServerSocket server;
	Socket socket;
	InputStream in = null;
	OutputStream out = null;
	
	public Server() {
		try {
			server = new ServerSocket(8088);
			System.out.println("服务器搭建完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void start() {
		while(true) {
			try {
				socket = server.accept();
				in = socket.getInputStream();
				out = socket.getOutputStream();
				System.out.println("已经链接上客户端");
				readSocket();
				writeSocket("我已经收到");
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void readSocket() {
		try {
			int d;
			while((d=in.read())!=-1) {
				char cur=(char)d;
				if(cur=='m') break;
				System.out.print(cur);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeSocket(String s) {
		try {
			byte[] data = s.getBytes();
			out.write(data);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
