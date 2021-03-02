package socket3;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//解析请求行
public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//1. 解析页面，输出页面值(一问）
			InputStream in = socket.getInputStream();
			int d;
			char cur = ' ';
			char pre = ' ';
			//保存所有读取的字符串
			/*
			 * String, StringBuffer, StringBuilder的区别和特点
			 * https://blog.csdn.net/csxypr/article/details/92378336
			 */
			StringBuilder builder = new StringBuilder();
			
			while((d=in.read()) != -1) {
				cur = (char) d;
			//如果上次读取的是回车符(13)，本次读取的是换行符(10)，则停止读取
				if(pre==13&&cur==10) {
					break;
				}
				builder.append(cur);//builder里面存放了一行的信息。
				pre=cur;
			}
			/*
			 * Returns a string whose value is this string, 
			 * with any leading and trailing whitespace removed.
			 * trim方法会输出string的值，并去掉首尾的空格 
			 */
			String line = builder.toString();
			System.out.print("请求行：" + line);
            /*
            下面的代码可能在运行后浏览器发送请求拆分时，在这里赋值给uri时出现
            字符串下表越界异常，这是由于浏览器发送了空请求，原因与常见错误5一样
           */
			String method;//请求方式
			String uri;//抽象路径
			String protocol;//协议版本
			
			String[] data = line.split("\\s");// \\s表示所有的空白符，包括空格和tab
			method = data[0];
			uri = data[1];
			protocol = data[2];
			System.out.println("method:" + method);
			System.out.println("uri:" + uri);
			System.out.println("protocol:" + protocol);
			
			//2. 处理页面信息
			
			//3. 响应页面（一答）
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭客户端
			try {
				socket.close();
				System.out.println("Client has lost connection.");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
