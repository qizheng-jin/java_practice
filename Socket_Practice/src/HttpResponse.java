import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * 这个类目前只干四件事：
 * 1.	发送HTTP/1.1	statusCode statusReason
 * 2.	发送Content-Type = text/html
 * 3.	发送Content-Length
 * 4.	发送响应正文
 *
 */
public class HttpResponse{
	private Socket socket;
	private int statusCode = 200;
	private String statusReason = "OK";
	private File entity;
	public HttpResponse(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	public void flush() {
		sendResponseLine();
		sendResonpseHeaders();
		sendContent();
	}
	
	/*
	 * 发送HTTP/1.1	200	OK
	 */
	private void sendResponseLine() {
		System.out.println("开始发送响应行");
		String line = "HTTP/1.1 " + statusCode + statusReason;
		try {
			writeIntoSocket(line);
			System.out.println("响应行: " + line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("响应行发送完毕");
	}
	
	/*
	 * 发送"Content-Type: text/html"
	 * 发送"Content-length: " + 文件长度
	 * 发送回车符换行符表示结束
	 */
	private void sendResonpseHeaders() {
		// TODO Auto-generated method stub
		System.out.println("开始发送响应头");
		try {
			String line = "Content-Type: text/html";
			
			writeIntoSocket(line);
			line = "Content-Length: " + entity.length();
			writeIntoSocket(line);
			
			writeIntoSocket("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("1213");
			e.printStackTrace();
		}
		System.out.println("响应头发送完毕");
	}
	
	/*
	 * 读取响应正文(HTML文件)
	 * 创建文件输入流和输出流读取文件
	 * 
	 */
	private void sendContent() {
		// TODO Auto-generated method stub
		System.out.println("开始发送响应正文");
		try(FileInputStream fis = new FileInputStream(entity);){
			OutputStream out = socket.getOutputStream();
			int len;//每次读取字节数
			byte[] buf = new byte[1024*10]; //一次读10kb字节数组
			while((len=fis.read(buf))!=-1) { //读取写入方法
				out.write(buf, 0, len);
				String s = new String(buf, "ISO8859-1");
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("响应正文发送完毕");
	}
	
	private void writeIntoSocket(String line) throws IOException {
		OutputStream out = socket.getOutputStream();
		//将line转化为byte[]然后进行写入操作.
		byte[] data = line.getBytes("ISO8859-1");
		out.write(data);
		out.write(13);
		out.write(10);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public File getEntity() {
		return entity;
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}
	
	
}