package socket6;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
	Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			WebHTTP request = new WebHTTP(socket);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
