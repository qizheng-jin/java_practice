import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * �����Ŀǰֻ���ļ��£�
 * 1.	����HTTP/1.1	statusCode statusReason
 * 2.	����Content-Type = text/html
 * 3.	����Content-Length
 * 4.	������Ӧ����
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
	 * ����HTTP/1.1	200	OK
	 */
	private void sendResponseLine() {
		System.out.println("��ʼ������Ӧ��");
		String line = "HTTP/1.1 " + statusCode + statusReason;
		try {
			writeIntoSocket(line);
			System.out.println("��Ӧ��: " + line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��Ӧ�з������");
	}
	
	/*
	 * ����"Content-Type: text/html"
	 * ����"Content-length: " + �ļ�����
	 * ���ͻس������з���ʾ����
	 */
	private void sendResonpseHeaders() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ������Ӧͷ");
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
		System.out.println("��Ӧͷ�������");
	}
	
	/*
	 * ��ȡ��Ӧ����(HTML�ļ�)
	 * �����ļ����������������ȡ�ļ�
	 * 
	 */
	private void sendContent() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ������Ӧ����");
		try(FileInputStream fis = new FileInputStream(entity);){
			OutputStream out = socket.getOutputStream();
			int len;//ÿ�ζ�ȡ�ֽ���
			byte[] buf = new byte[1024*10]; //һ�ζ�10kb�ֽ�����
			while((len=fis.read(buf))!=-1) { //��ȡд�뷽��
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
		System.out.println("��Ӧ���ķ������");
	}
	
	private void writeIntoSocket(String line) throws IOException {
		OutputStream out = socket.getOutputStream();
		//��lineת��Ϊbyte[]Ȼ�����д�����.
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