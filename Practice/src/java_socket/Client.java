package java_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
	
	private Socket socket; 
	private InputStream in = null;
	private OutputStream out = null;
	public Client(){
		try {
			socket = new Socket("127.0.0.1", 8088);
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("输入传给服务器的话：");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		writeSocket(s);
		readSocket();
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readSocket() {
		int d;
		try {
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
		byte[] data = s.getBytes();
		try {
			out.write(data);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
			Client client = new Client();
			client.run();
		
	}
}
