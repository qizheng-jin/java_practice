package day1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * 客户端 -- Socket
 * 读取服务器发来的数据
 * 给服务器写出数据
 *
 */
public class ClientSocket {
	public static void main(String[] args) {
		OutputStream out = null;
		try {
			//Socket socket = new Socket("连接对象的IP地址", int 端口值) 192.168.58.1
			Socket socket = new Socket("127.0.0.1", 8088);
			System.out.println("与服务器连接成功");
			out = socket.getOutputStream();
			System.out.println("输入一句话");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			byte[] data = s.getBytes("UTF-8");
			out.write(data);
			/**
			 * .close()和.flush()的区别:
			 * close()刷新之后关闭资源
			 * .flush()只是刷新不关闭资源
			 */
			out.flush();
			System.out.println("写入完毕, 客户端开始读取:");
			
			InputStream in = socket.getInputStream();
			int d;
			char cur = ' ';
			char pre = ' ';
			while((d=in.read())!=-1) {
				System.out.print((char)d);
				cur = (char)d;
				if(cur == 'm') break;
				pre = cur;
			}
			System.out.println("读取完毕");
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			try {
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
