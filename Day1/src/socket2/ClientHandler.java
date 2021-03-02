package socket2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	/*
	 * 处理用户端信息分为三步
	 * 1. 解析请求
	 * 2. 处理请求
	 * 3. 发送响应
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// 1. 解析请求，即读取客户端发来的信息
			System.out.println("-----开始读取客户端信息-----");
			InputStream in = socket.getInputStream();
			int d;
			while ((d=in.read()) != -1) {
				System.out.print((char)d);
			}
			System.out.println("-----读取客户端信息完毕-----");
			//2. 处理请求
			
			//3. 发送响应
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//处理完毕后断开与客户端连接
			
			try {
				socket.close();
				System.out.println("connection has been closed.");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
