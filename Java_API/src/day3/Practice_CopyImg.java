package day3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Practice_CopyImg {
	
	/**
	 * 
	 * ��ΪbufferedInputStream && bufferedOutputStream�ܴ�Сֻ��8kb,����һ�ζ�ȡ���ļ���С���ֻ��8kb,
	 * ������ȳ���,����Ҫ�ȴ���һ��8kb������,һ�ζ�8kb��ȥ      .read(byte[] b): һ�ν�b�����ȡ��
	 * 
	 * 	 */
	public static void copyFile(File read, File write) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(read));
			bos = new BufferedOutputStream(new FileOutputStream(write));
			byte[] data = new byte[8192]; // ���Ƚ�����Դ�뱣��һ�� 8kb,Դ������ֻ��8kb
			int len;
			while((len=bis.read(data))!= -1) {
				bos.write(data, 0, len);
				System.out.println(len);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("D://UofG.jpg");
		File f2 = new File("D://���汳��/pei_qi.jpg");
		copyFile(f1, f2);
	}
}
