package load_static_files;

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
	private String paraLine;
	private Map<String, String> parameters = new HashMap<String, String>();

	public HttpRequest(Socket socket) throws EmptyRequestException{
		super();
		this.socket = socket;
		parseLine();
		parseHeaders();
		parseContent();
	}
	
	private void parseLine() throws EmptyRequestException{
		System.out.println("发送请求行");
		try {
			String line = readLine();
			String[] data = line.split("\\s");
			method = data[0];
			uri = data[1];
			protocol = data[2];
			
			System.out.println("method is " + method +
								"uri is " + parsedUri +
								"protocol is " + protocol);
			parseUri(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parseHeaders() {
		System.out.println("开始处理请求头");
		try {
			String line = readLine();
			System.out.println(line);
			String[] data = line.split(":");
			if(data.length>1)
			headers.put(data[0], data[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 如果method是post则会有正文
	 * 找寻正文长度
	 * 如果长度不为零
	 * 找寻decode
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
					String type = headers.get("Content-Type");
					if("application/x-www-form-urlencoded".equalsIgnoreCase(type)) {
						String content = new String(data, "UTF-8");
						content = URLDecoder.decode(content);
						System.out.println("响应正文是: " + content);
						parseParameters(content);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	private void parseUri(String line) {
		//找有没有参数呀
		if(line.contains("?")) {
			String[] data = line.split("\\?");
			parsedUri = data[0];
			if(data.length > 1) {
				paraLine = data[1];
				parseParameters(paraLine);
			}
		}else {
			parsedUri = uri;
		}
		
	}
	
	private void parseParameters(String line) {
		String[] data = line.split("&");
		for(String str:data) {
			String[] paraList = str.split("=");
			parameters.put(paraList[1], paraList[2]);
		}
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

	public String getParaLine() {
		return paraLine;
	}

	public String getParameters(String key) {
		return parameters.get(key);
	}
	
	
}
