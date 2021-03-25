package day3;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test_OutputStream {
	
	public static void method1(String line, File file) {
		//1. 创建流对象, OutputStream是抽象父类不能实例化
		OutputStream out  = null;
		line = method3(file) + line;
		try {
			out = new FileOutputStream(file);
		//2. 输入数据
			byte[] data = line.getBytes();
			out.write(data);
			System.out.println("写入完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. 释放资源
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	public static void method2(String line, File file) {
		OutputStream out = null;
		line = method3(file) + line;
		try {
			out = new BufferedOutputStream(new FileOutputStream(file));
			byte[] data = line.getBytes();
			out.write(data);
			
			System.out.println("写入完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//输出流一定要关闭呀！
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String method3(File file) {
		InputStream in = null;
		String s = "";
		try {
			in = new FileInputStream(file);
			int d;
			while((d=in.read())!=-1) {
				s += (char)d;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static void main(String[] args) {
		String line = " EHero-FlamewingerMan ";
		File file = new File("test_output.txt");
		System.out.println(file.getAbsolutePath());
		/**
		 * 接着结尾写，要先用输入字节流，读取原本文件所有文件，然后接着写
		 */
		if(file.exists() && file.isFile()) {
			method1(line, file);
			method1(" EHero-LighteningMan ", file);
			method2(" EHero-EarthMan\n", file);
		}
	}
}
