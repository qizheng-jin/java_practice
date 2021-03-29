package day1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * �ͻ��� -- Socket
 * ��ȡ����������������
 * ��������д������
 *
 */
public class ClientSocket {
	public static void main(String[] args) {
		OutputStream out = null;
		try {
			//Socket socket = new Socket("���Ӷ����IP��ַ", int �˿�ֵ) 192.168.58.1
			Socket socket = new Socket("127.0.0.1", 8088);
			System.out.println("����������ӳɹ�");
			out = socket.getOutputStream();
			System.out.println("����һ�仰");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			byte[] data = s.getBytes("UTF-8");
			out.write(data);
			/**
			 * .close()��.flush()������:
			 * close()ˢ��֮��ر���Դ
			 * .flush()ֻ��ˢ�²��ر���Դ
			 */
			out.flush();
			System.out.println("д�����, �ͻ��˿�ʼ��ȡ:");
			
			InputStream in = socket.getInputStream();
			int d;
			char cur = ' ';
			char pre = ' ';
			while((d=in.read())!=-1) {
				System.out.print((char)d);
				cur = (char)d;
				if(cur == 'm') break;
				pre = cur;
			}
			System.out.println("��ȡ���");
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			try {
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
