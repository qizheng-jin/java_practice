package httpresponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * 写三句话：
 * 
 * HTTP 1.1/ 200 OK
 * Content-Type: text/html
 * Content-Length: text/html
 * 响应正文
 *
 */
public class HttpResponse {
	private Socket socket;
	private File entity;
	private int statusCode = 200;
	private String statusReason = "OK";
	
	public HttpResponse(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void flush() {
		writeResponsedLine();
		writeHeaders();
		writeContent();
	}
	
	private void writeResponsedLine() {
		System.out.println("开始写入响应行");
		String responsedLine = "HTTP/1.1 " + statusCode + " " +  statusReason;
		try {
			writeIntoSocket(responsedLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("响应行写入完毕, 写入: " + responsedLine);
	}
	
	private void writeHeaders() {
		System.out.println("开始写入响应头");
		try {
			String line = "Content-Type: text/html";
			writeIntoSocket(line);
			System.out.println("Content-Type is " + line);
			line = "Content-Length: " + entity.length();
			System.out.println("Content-Length is " +line);
			writeIntoSocket(line);
			writeIntoSocket("");
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("响应头写入完毕");
	}
	
	private void writeContent() {
		System.out.println("开始写入响应正文");
		try {
			FileInputStream fis = new FileInputStream(entity);
			byte[] data = new byte[10*1024]; // 10kb的容器
			OutputStream out = socket.getOutputStream();
			int len;
			while((len=fis.read(data))!=-1) {
				out.write(data, 0, len);
				String s = new String(data, "ISO8859-1");
				System.out.println(s);
			}
			out.write(13);
			out.write(10);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("响应正文写入完毕");
	}
	
	
	private void writeIntoSocket(String line) throws IOException {
		OutputStream out = socket.getOutputStream();
		byte[] data = line.getBytes("ISO8859-1");
		out.write(data);
		out.write(13);
		out.write(10);
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	
	
}
