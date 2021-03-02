import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * С��WebServer
 * ʵ��Tomcat�Ļ������ܵ�һ��Web����
 * Web���������ã�
 * 1��Web������һ��Web����˳��򣬸�����ͻ��ˣ�ͨ��������������н���
 * 2�������ͻ��˵�TCP���Ӽ����ݽ�����
 * 3������HTTPЭ����ͻ��˽���Ӧ�ý������ǵ���������Է���Web�����в���
 * �Ĳ�ͬ����Ӧ�ã�Webapp����ҳ�棬��Դ�����ܵȡ�
 * 4�����Թ���������ͬ������Ӧ�á�
 */
public class WebServer {
	private ServerSocket serverSocket;
	//������������Ҫȷ���������˿ڡ�
	public WebServer() {
		try {
			System.out.println("ready to run");
			serverSocket = new ServerSocket(8088);
			System.out.println("The socket has started");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����������
	public void start() {
		try {
			System.out.println("Waiting for connection.");
			Socket socket = serverSocket.accept();
			System.out.println("�ͻ������ӳɹ���");
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebServer server = new WebServer();
		server.start();
	}

}
