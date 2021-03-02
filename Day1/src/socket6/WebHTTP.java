package socket6;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class WebHTTP {
	private String method;
	private String uri;
	private String protocol;
	
	private Map<String, String> headers = new HashMap<String, String>();
	
	private Socket socket;
	
	public WebHTTP(Socket socket) {
		this.socket = socket;
        //1����������
        parseRequestLine();
        //2������Ϣͷ
        parseRequestHeaders();
	}
	
    //1������������
    // ��\\s�ֿ� �� method uri �� protocol
	private void parseRequestLine() {
		System.out.println("-------��ʼ����������------");
		try {
			String line = readLine();
			String[] data = line.split("\\s");
			method = data[0];
			uri = data[1];
			protocol = data[2];
            System.out.println("method:"+method);
            System.out.println("uri:"+uri);
            System.out.println("protocol:"+protocol);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//2. ������Ϣͷ
	private void parseRequestHeaders() {
		System.out.println("-----��ʼ������Ϣͷ-------");
		try {
			while (true) {
				String line = readLine();
				if(line.isEmpty()) break;
				String[] data = line.split(":");
				headers.put(data[0], data[1]);
				System.out.println("��Ϣͷ��"+line);
			}
			System.out.println("headers :" + headers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String readLine() throws IOException{
		int d;
		char cur = ' ';
		char pre = ' ';
		StringBuilder builder = new StringBuilder();
		InputStream in = socket.getInputStream();
		while((d=in.read())!=-1) {
			cur = (char)d;
			if(pre == 13 && cur == 10) break;
			
			builder.append(cur);
			pre = cur;
		}
		return builder.toString().trim();
	}
	
}
