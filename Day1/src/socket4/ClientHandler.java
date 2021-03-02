package socket4;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			String line = readLine();
			String method;
			String uri;
			String protocol;
			//通过空格或者tab分割字符串,成为一个字符串数组
			String[] data = line.split("\\s");
			method = data[0];
			uri = data[1];
			protocol = data[2];
			System.out.println("method:" + method);
			System.out.println("uri:" + uri);
			System.out.println("protocol:" + protocol);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	private String readLine() throws IOException {
		InputStream in = socket.getInputStream();
		StringBuilder builder = new StringBuilder();
		char cur = ' ';
		char pre = ' ';
		int d;
		while((d=in.read())!=-1) {
			cur = (char) d;
			if(pre==13 && cur==10) {
				break;
			}
			builder.append(cur);
			pre = cur;
		}
		
		return builder.toString().trim();
	}
}
