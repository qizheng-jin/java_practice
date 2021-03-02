import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	private static final String defaultPath = "Webapps";
	public ClientHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			HttpRequest request = new HttpRequest(socket);
			HttpResponse response = new HttpResponse(socket);
			String path = request.getParsedUri();
			File file = new File(defaultPath + path);
			System.out.println(file.getAbsolutePath());
			System.out.println(file.isDirectory());
			if(file.isFile() && file.exists()) { 
				System.out.println("�ҵ���Ŀ���ļ�");
			}else {
				System.out.println("û���ҵ�Ŀ���ļ�");
				path = "/404_not_found.html";
				file = new File(defaultPath + path);
				System.out.println(file.getAbsolutePath());
			}
			response.setEntity(file);
			response.flush();
			System.out.println("��Ӧ���ķ������");
			//read();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void read() {
		try {
			InputStream in = socket.getInputStream();
			int d;
			StringBuilder builder = new StringBuilder();
			char cur;
			System.out.println("start");
			while((d=in.read()) != -1) {
				cur = (char)d;
				builder.append(cur);
			}
			System.out.println(builder.toString().trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}