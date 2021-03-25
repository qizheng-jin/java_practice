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
		//1. ����������, OutputStream�ǳ����಻��ʵ����
		OutputStream out  = null;
		line = method3(file) + line;
		try {
			out = new FileOutputStream(file);
		//2. ��������
			byte[] data = line.getBytes();
			out.write(data);
			System.out.println("д�����");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. �ͷ���Դ
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
			
			System.out.println("д�����");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�����һ��Ҫ�ر�ѽ��
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
		 * ���Ž�βд��Ҫ���������ֽ�������ȡԭ���ļ������ļ���Ȼ�����д
		 */
		if(file.exists() && file.isFile()) {
			method1(line, file);
			method1(" EHero-LighteningMan ", file);
			method2(" EHero-EarthMan\n", file);
		}
	}
}
