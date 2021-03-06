import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
	private Socket socket;
	private String method;
	private String uri;
	private String protocol;
	private Map<String, String> headers = new HashMap<String, String>();
	
	private String parsedUri;
	private Map<String, String> parameter = new HashMap<String, String>();
	
	public HttpRequest(Socket socket) {
		this.socket = socket;
		parseLine();
		parseHeaders();
		parseContent();
	}
	
	private void parseLine() {
		System.out.println("开始解析消息行");
		try {
			String line = readLine();
			String[] data = line.split("\\s");
			method = data[0];
			uri = data[1];
			protocol = data[2];
			parseUri();
			System.out.println("method is " + method + "\n" + 
								"uri is "  + uri + "\n" +
								"protocol is " + protocol);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parseHeaders() {
		System.out.println("开始解析消息头");
		while(true) {
			try {
				String line = readLine();
				if (line.isEmpty()) break;
				String[] data = line.split(":");
				headers.put(data[0], data[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 1. 进一步分析uri
	 * 2. 如果网页链接中含参数(GET函数)
	 * 	2.1	将链接从?拆分,前面是域名,后面是参数
	 * 	2.2	将参数部分通过"&"拆分,每一个单独的都是一个参数
	 * 	2.3	将参数部分通过"="拆分,等号左边为变量名，右边为属性
	 * 		存入一个hashmap之中.
	 * 3. 如果不含参数,则parsedUri = uri
	 */
	private void parseUri() {
		if(uri.contains("?")) {
			String[] data = uri.split("\\?");
			parsedUri = data[0];
			if(data.length > 1) {
				String paraLine = data[1];
				parseParameter(paraLine);
				System.out.println("parsedUri is " + parsedUri);
				System.out.println("parameter is " + parameter);
			}
		}else {
			parsedUri = uri;
		}
	}
	
	private void parseParameter(String line) {
		String[] data = line.split("&");
		for(String str:data) {
			String[] para = str.split("=");
			parameter.put(para[0], para[1]);
		}
	}
	
	
	/*
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
		System.out.println("开始解析消息正文");
		if(method.equalsIgnoreCase("post")) {
			String len = headers.get("Content-Length");
			if(len != null) {
				int length = Integer.parseInt(len);//强制类型转换
				byte[] data = new byte[length];
				try {
					InputStream in = socket.getInputStream();
					in.read(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//根据消息头Content_Type了解浏览器发送过来的正文是什么并进行对应的处理
				String type = headers.get("Content-Type");
				if(type.equalsIgnoreCase("application/x-www-form-urlencoded")) {
					try {
						String line = new String(data, "UTF-8");
						line = URLDecoder.decode(line, "UTF-8");
						System.out.println("消息正文: " + line);
						parseParameter(line);
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

		InputStream in = socket.getInputStream();
		char cur = ' ';
		char pre = ' ';
		int d = -1;
		
		while((d=in.read()) != -1) {
			cur = (char) d;
			if (pre == 13 && cur == 10) break;
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

	public String getParameter(String key) {
		return parameter.get(key);
	}	
	
}
