package load_static_execise;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
	private Socket socket;
	private String method;
	private String uri;
	private String protocol;
	private Map<String, String> headers = new HashMap<String, String>();
	
	private String parsedUri;
	private Map<String, String> parameters = new HashMap<String, String>();
	public HttpRequest(Socket socket) {
		this.socket = socket;
		parseLine();
		parseHeaders();
		parseContent();
	}
	
	private void parseLine() {
		System.out.println("开始传送请求行");
		try {
			String line = readLine();
			String data[] = line.split("\\s");
			method = data[0];
			uri = data[1];
			protocol = data[2];
			System.out.println(method + ", " + uri + ", " + protocol);
			parseUri(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("请求行传送完毕");
	}
	
	private void parseUri(String l) {
		
		if(l.contains("?")) {
			System.out.println("这个url含参");
			String[] data = l.split("\\?");
			parsedUri = data[0];
			if(data.length>1) {
				String paraLine = data[1];
				parseParameters(paraLine);
			}	
		}else {
			parsedUri = uri;
		}
		
	}
	
	private void parseParameters(String l) {
		String[] data = l.split("&");
		for(String str:data) {
			String[] para = str.split("=");
			if(para.length > 1) {
				parameters.put(para[0], para[1]);
			}
		}
	}
	
	private void parseHeaders() {
		System.out.println("开始传送响应头");
		while(true) {
			try {
					String line = readLine();
					if(line.isEmpty()) break;
					String[] data = line.split(":");
					if(data.length > 1) {
						headers.put(data[0], data[1]);
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Post方法含有参数
	 */
	private void parseContent() {
		System.out.println("开始发送响应正文");
		if(method.equalsIgnoreCase("post")) {
			String len = headers.get("Content-Length");		
			String type = headers.get("Content-Type");
			if(len != null) {
				int length = Integer.parseInt(len);
				byte[] data = new byte[length];
				try {
					InputStream in = socket.getInputStream();
					in.read(data);
					if(type.equalsIgnoreCase("application/x-www-form-urlencoded")) {
						String line = new String(data, "UTF-8");
						line = URLDecoder.decode(line);
						parseParameters(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("发送响应正文完毕");
	}
	
	private String readLine() throws IOException {
		StringBuilder builder = new StringBuilder();
		InputStream in = socket.getInputStream();
		char cur = ' ';
		char pre = ' ';
		int d;
		while((d=in.read())!=-1) {
			cur = (char)d;
			if(pre==13 && cur==10) break;
			builder.append(cur);
			pre = cur;
		}
		System.out.println("builder is " + builder.toString().trim());
		return builder.toString().trim();
	}

	public Socket getSocket() {
		return socket;
	}

	public String getMethod() {
		return method;
	}

	public String getUri() {
		return uri;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getHeaders(String key) {
		return headers.get(key);
	}

	public String getParsedUri() {
		return parsedUri;
	}

	public String getParameters(String key) {
		return parameters.get(key);
	}
	
	
}
