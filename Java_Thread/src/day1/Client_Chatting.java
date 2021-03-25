package day1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client_Chatting implements Runnable{
	Socket socket;
	
	public Client_Chatting(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			int d;
			StringBuilder builder = new StringBuilder();
			while((d=in.read())!=-1) {
				builder.append((char)d);
			}
			System.out.println(builder.toString());
			
			Scanner scan = new Scanner(System.in);
			System.out.println("写下传给服务器的话： ");
			String line = scan.nextLine();
			byte[] data = line.getBytes();
			out.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
