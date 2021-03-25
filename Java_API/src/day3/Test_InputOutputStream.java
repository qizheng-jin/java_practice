package day3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 测试文件的读取
 * 
 * 字节流:InputStream
 * 
 * 字符流: FileReader
 */
public class Test_InputOutputStream {
	public static void main(String[] args) {
		method();
	}
	
	public static void method2() {
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File("text.txt")));//高效文件读取器
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void method() {
		File file = new File("test.txt");
		System.out.println(file.getAbsolutePath());
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			int d;
			//in.read byte => char(in.read())
			while((d=in.read())!= -1) {
				char c = (char)d;
				System.out.print(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
