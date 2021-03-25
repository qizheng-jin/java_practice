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
	 * 因为bufferedInputStream && bufferedOutputStream总大小只有8kb,所以一次读取的文件大小最多只有8kb,
	 * 如果长度超标,则需要先创建一个8kb的数组,一次读8kb进去      .read(byte[] b): 一次将b数组读取满
	 * 
	 * 	 */
	public static void copyFile(File read, File write) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(read));
			bos = new BufferedOutputStream(new FileOutputStream(write));
			byte[] data = new byte[8192]; // 长度建议与源码保持一致 8kb,源码容量只有8kb
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
		File f2 = new File("D://桌面背景/pei_qi.jpg");
		copyFile(f1, f2);
	}
}
