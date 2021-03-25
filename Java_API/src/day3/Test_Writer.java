package day3;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
public class Test_Writer {
	
	public static void method1(String line, File file) {
		FileWriter writer = null;
		line = method3(file) + line;
		try {
			writer = new FileWriter(file);
			writer.write(line);
			System.out.println("写入完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void method2(String line, File file) {
		BufferedWriter out = null;
		line = method3(file) + line;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(line);
			System.out.println("写入完毕");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String method3(File file) {
		String s = "";
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			int d;
			while((d=in.read()) != -1) {
				s += (char)d;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
		
	}
	public static void main(String[] args) {
		File file = new File("test_output.txt");
		method1("EHero-FlameWingerMan", file);
	}
	
	
}
