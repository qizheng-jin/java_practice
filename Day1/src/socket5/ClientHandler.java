package socket5;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String line = readLine();
		line = readLine();//��һ����û��ð�ŵģ�����Ҫ�ӵڶ��п�ʼ
		Map<String, String> headers = new HashMap<String, String>();
		while(!line.isEmpty()) {
			String[] data = line.split(":");		
			headers.put(data[0], data[1]);
			System.out.println("line is " + line);
			line = readLine();
		}
//		  ��ʦ����		
//        while (true) {
//
//            line = readLine();
//
//
//            //��ȡ��Ϣͷʱ�����ֻ�����˻س��ӻ��з���Ӧ��ֹͣ��ȡ
//            if (line.isEmpty()){//readLine������ȡCRLF����ֵӦ���ǿ��ַ���
//                break;
//            }
//            String[] str = line.split(":");
//            headers.put(str[0],str[1]);
//            System.out.println("��Ϣͷ��"+line);
//        }
		System.out.println("����headers �� " + headers);
		try {
			socket.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private String readLine() {
        /*
        ��socket������ͬʱ�����۵����ٴ�getInputStream��������ȡ������������
        ����ͬһ�����������Ҳ��һ���ġ�
      */
		StringBuilder builder = new StringBuilder();
		try {
			InputStream in = socket.getInputStream();
			char cur = ' ';
			char pre = ' ';
			int d;
			while ((d=in.read()) != -1) {
				cur = (char)d;
				if(pre == 13 && cur == 10) {
					break;
				}
				builder.append(cur);
				pre = cur;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return builder.toString().trim();
	}
}
