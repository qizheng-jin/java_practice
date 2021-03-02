package httpresponse;

import java.io.File;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	private final static String defaultPath = "webapps/";
	public ClientHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		HttpRequest request = new HttpRequest(socket);
		HttpResponse response = new HttpResponse(socket);
		String path = request.getParsedUri();
		File file = new File(defaultPath + path);
		if(file.exists() && file.isFile()) {
			System.out.println("�ҵ�Ŀ���ļ�");
			response.setEntity(file);

		}else {
			System.out.println("û�ҵ�Ŀ���ļ�");
			path = "404_not_found.html";
			file = new File(defaultPath + path);
			response.setEntity(file);
		}
		response.flush();
		System.out.println("��Ӧ�������");
	}

}