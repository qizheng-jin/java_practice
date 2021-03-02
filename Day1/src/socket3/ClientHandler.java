package socket3;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//����������
public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//1. ����ҳ�棬���ҳ��ֵ(һ�ʣ�
			InputStream in = socket.getInputStream();
			int d;
			char cur = ' ';
			char pre = ' ';
			//�������ж�ȡ���ַ���
			/*
			 * String, StringBuffer, StringBuilder��������ص�
			 * https://blog.csdn.net/csxypr/article/details/92378336
			 */
			StringBuilder builder = new StringBuilder();
			
			while((d=in.read()) != -1) {
				cur = (char) d;
			//����ϴζ�ȡ���ǻس���(13)�����ζ�ȡ���ǻ��з�(10)����ֹͣ��ȡ
				if(pre==13&&cur==10) {
					break;
				}
				builder.append(cur);//builder��������һ�е���Ϣ��
				pre=cur;
			}
			/*
			 * Returns a string whose value is this string, 
			 * with any leading and trailing whitespace removed.
			 * trim���������string��ֵ����ȥ����β�Ŀո� 
			 */
			String line = builder.toString();
			System.out.print("�����У�" + line);
            /*
            ����Ĵ�����������к����������������ʱ�������︳ֵ��uriʱ����
            �ַ����±�Խ���쳣��������������������˿�����ԭ���볣������5һ��
           */
			String method;//����ʽ
			String uri;//����·��
			String protocol;//Э��汾
			
			String[] data = line.split("\\s");// \\s��ʾ���еĿհ׷��������ո��tab
			method = data[0];
			uri = data[1];
			protocol = data[2];
			System.out.println("method:" + method);
			System.out.println("uri:" + uri);
			System.out.println("protocol:" + protocol);
			
			//2. ����ҳ����Ϣ
			
			//3. ��Ӧҳ�棨һ��
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�رտͻ���
			try {
				socket.close();
				System.out.println("Client has lost connection.");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
