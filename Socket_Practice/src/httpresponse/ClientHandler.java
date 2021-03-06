package httpresponse;

import java.io.File;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	private final static String defaultPath = "webapps/html_files";
	public ClientHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	@Override
	public void run() {
		try {	
		// TODO Auto-generated method stub
			HttpRequest request = new HttpRequest(socket);
			HttpResponse response = new HttpResponse(socket);
			String path = request.getParsedUri();
			System.out.println("path is " + path);
			File file = new File(defaultPath + path);
			if(file.exists() && file.isFile()) {
				System.out.println("找到目标文件");
				System.out.println(file.getAbsolutePath());
				response.setEntity(file);
	
			}else {
				System.out.println("没找到目标文件");
				path = "/404_not_found.html";
				file = new File(defaultPath + path);
				System.out.println(file.getAbsolutePath());
				response.setEntity(file);
			}
			response.flush();
			System.out.println("响应发送完毕");
		}catch(EmptyRequestException e) {
			e.printStackTrace();
		}
	}

}
