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
        //1解析请求行
        parseRequestLine();
        //2解析消息头
        parseRequestHeaders();
	}
	
    //1：解析请求行
    // 用\\s分开 成 method uri 和 protocol
	private void parseRequestLine() {
		System.out.println("-------开始解析请求行------");
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
	
	
	//2. 解析消息头
	private void parseRequestHeaders() {
		System.out.println("-----开始解析消息头-------");
		try {
			while (true) {
				String line = readLine();
				if(line.isEmpty()) break;
				String[] data = line.split(":");
				headers.put(data[0], data[1]);
				System.out.println("消息头："+line);
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
