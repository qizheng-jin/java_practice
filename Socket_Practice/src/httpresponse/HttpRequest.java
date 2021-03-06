package httpresponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
	private	Map<String, String> parameters =new HashMap<String, String>();

	public HttpRequest(Socket socket) throws EmptyRequestException{
		this.socket = socket;
		parseLine();
		parseHeaders();
		parseContent();
	}
	
	private void parseLine() throws EmptyRequestException{
		try {
			String line = readLine();
			String[] data = line.split("\\s");
			method = data[0];
			uri = data[1];
			protocol =data[1];
			parseUri();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parseHeaders() {
		while(true) {
			try {
				String line = readLine();
				if(line.isEmpty()) break;
				String[] data = line.split(":");
				headers.put(data[0], data[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void parseUri() {
		//看看uri里面有没有?
		if(uri.contains("?")) {
			String[] data = uri.split("\\?");
			parsedUri = data[0];
			if(data.length > 1) {
				String paraLine = data[1];
				parseParameters(paraLine);
			}
		}
		parsedUri = uri;
	}
	
	private void parseParameters(String line) {
		String[] data = line.split("&");
		for(String str:data) {
			String[] paraList = str.split("=");
			parameters.put(data[0], data[1]);
		}
	}
	
	/**
	 * 如果method里面有post.要解码post里面的内容.
	 * 
	 * POST方法就会有响应正文
	 * 1.	如果消息头中的方法(method)为post
	 * 	1.1		解析消息头中的消息正文长度(Content-Length)是否为空
	 * 		1.1.1	如果正文长度不为零,创建InputStream,将读取内容存入一个byte[]中.
	 * 		1.1.2	读取完Content-Length之后再读取Content-Type
	 * 		1.1.3	如果Content-Type是form表单
	 * 			1.1.3.1	获得被加密过的代码,并解译,得到line.
	 * 			1.1.3.1 调用parseParameter方法将line转变为parameter,
	 * 		
	 */
	private void parseContent() {
		if(method.equalsIgnoreCase("post")) {
			String len = headers.get("Content-Length");
			if(len != null) {
				int length = Integer.parseInt(len);
				byte[] data = new byte[length];
				try {
					InputStream in = socket.getInputStream();
					in.read(data);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//读取完Content-Length之后再读取Content-Type
				String type = headers.get("Content-Type");
				if(type.equalsIgnoreCase("application/x-www-form-urlencoded")) {
					try {
						String line = new String(data, "UTF-8");
						line = URLDecoder.decode(line, "UTF-8");
						System.out.println("消息正文:" + line);
						parseParameters(line);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	
	private String readLine() throws IOException {
		StringBuilder builder = new StringBuilder();
		char cur = ' ';
		char pre = ' ';
		int d;
		InputStream in = socket.getInputStream();
		while((d=in.read())!=-1) {
			cur = (char)d;
			if(pre==13 && cur==10) break;
			builder.append(cur);
			pre = cur;
		}
		return builder.toString().trim();
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
