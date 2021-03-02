package socket2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	/*
	 * �����û�����Ϣ��Ϊ����
	 * 1. ��������
	 * 2. ��������
	 * 3. ������Ӧ
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// 1. �������󣬼���ȡ�ͻ��˷�������Ϣ
			System.out.println("-----��ʼ��ȡ�ͻ�����Ϣ-----");
			InputStream in = socket.getInputStream();
			int d;
			while ((d=in.read()) != -1) {
				System.out.print((char)d);
			}
			System.out.println("-----��ȡ�ͻ�����Ϣ���-----");
			//2. ��������
			
			//3. ������Ӧ
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//������Ϻ�Ͽ���ͻ�������
			
			try {
				socket.close();
				System.out.println("connection has been closed.");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
