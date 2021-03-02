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
		System.out.println("��ʼ������Ϣ��");
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
		System.out.println("��ʼ������Ϣͷ");
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
	 * 1. ��һ������uri
	 * 2. �����ҳ�����к�����(GET����)
	 * 	2.1	�����Ӵ�?���,ǰ��������,�����ǲ���
	 * 	2.2	����������ͨ��"&"���,ÿһ�������Ķ���һ������
	 * 	2.3	����������ͨ��"="���,�Ⱥ����Ϊ���������ұ�Ϊ����
	 * 		����һ��hashmap֮��.
	 * 3. �����������,��parsedUri = uri
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
	 * POST�����ͻ�����Ӧ����
	 * 1.	�����Ϣͷ�еķ���(method)Ϊpost
	 * 	1.1		������Ϣͷ�е���Ϣ���ĳ���(Content-Length)�Ƿ�Ϊ��
	 * 		1.1.1	������ĳ��Ȳ�Ϊ��,����InputStream,����ȡ���ݴ���һ��byte[]��.
	 * 		1.1.2	��ȡ��Content-Length֮���ٶ�ȡContent-Type
	 * 		1.1.3	���Content-Type��form����
	 * 			1.1.3.1	��ñ����ܹ��Ĵ���,������,�õ�line.
	 * 			1.1.3.1 ����parseParameter������lineת��Ϊparameter,
	 * 		
	 */
	private void parseContent() {
		System.out.println("��ʼ������Ϣ����");
		if(method.equalsIgnoreCase("post")) {
			String len = headers.get("Content-Length");
			if(len != null) {
				int length = Integer.parseInt(len);//ǿ������ת��
				byte[] data = new byte[length];
				try {
					InputStream in = socket.getInputStream();
					in.read(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//������ϢͷContent_Type�˽���������͹�����������ʲô�����ж�Ӧ�Ĵ���
				String type = headers.get("Content-Type");
				if(type.equalsIgnoreCase("application/x-www-form-urlencoded")) {
					try {
						String line = new String(data, "UTF-8");
						line = URLDecoder.decode(line, "UTF-8");
						System.out.println("��Ϣ����: " + line);
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