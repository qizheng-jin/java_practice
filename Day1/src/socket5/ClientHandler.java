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
		line = readLine();//第一行是没有冒号的，所以要从第二行开始
		Map<String, String> headers = new HashMap<String, String>();
		while(!line.isEmpty()) {
			String[] data = line.split(":");		
			headers.put(data[0], data[1]);
			System.out.println("line is " + line);
			line = readLine();
		}
//		  老师方法		
//        while (true) {
//
//            line = readLine();
//
//
//            //读取消息头时，如果只读到了回车加换行符就应当停止读取
//            if (line.isEmpty()){//readLine单独读取CRLF返回值应当是空字符串
//                break;
//            }
//            String[] str = line.split(":");
//            headers.put(str[0],str[1]);
//            System.out.println("消息头："+line);
//        }
		System.out.println("所有headers ： " + headers);
		try {
			socket.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private String readLine() {
        /*
        当socket对象相同时，无论调多少次getInputStream方法，获取回来的输入流
        总是同一个流。输出流也是一样的。
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
