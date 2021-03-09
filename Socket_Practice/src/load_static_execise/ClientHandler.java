package load_static_execise;

import java.io.File;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	private static final String defaultPath = "Webapps";
	public ClientHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("??????");
		HttpRequest request =new HttpRequest(socket);
		
		String path = request.getUri();
		File file = new File(defaultPath + path);
		System.out.println(file.getAbsolutePath());
		if(file.exists() && file.isFile()) {
			System.out.println("已经找到目标文件");
		}else {
			System.out.println("找到个屁");
		}
	}
}
