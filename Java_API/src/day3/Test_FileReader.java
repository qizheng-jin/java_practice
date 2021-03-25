package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 
 * 
 *
 */
public class Test_FileReader {
	public static void main(String[] args) {
		File file = new File("test.txt");
		System.out.println(file.getAbsolutePath());
		if(file.exists()&&file.isFile()) {
			method1(file);
			method2(file);
		}
	}
	
	public static void method1(File file) {
		Reader reader = null;
		try {
			reader = new FileReader(file);
//			FileReader f = (FileReader) reader;
			int d;
			while((d=reader.read()) != -1)
				System.out.print((char)d);
			System.out.print("\n");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * BufferedReader是一个搞笑的字符读取流
	 * 底层维护了一个char[], 数组长度是8*1024=8192,8k
	 */
	public static void method2(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			int d;
			while((d=br.read())!=-1)
				System.out.print((char)d);
			
			System.out.println("\n读取完毕");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
