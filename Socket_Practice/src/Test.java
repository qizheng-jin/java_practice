import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * 这个类目前只干三件事：
 * 1.	发送Content-Type = text/html
 * 2.	发送Content-Length
 * 3.	发送响应正文
 *
 */
public class Test{
	static int a = 0;
	public static void main(String[] args) {
		System.out.println(a);
	}
}