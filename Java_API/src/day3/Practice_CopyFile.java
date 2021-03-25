package day3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Practice_CopyFile {
	public static void main(String[] args) {
		Practice_CopyFile pc = new Practice_CopyFile();
		Scanner in = new Scanner(System.in);
		System.out.println("�����뱻�����ļ�·��(����׺)");
		File originalFile = new File(in.nextLine());
		if(originalFile.exists() && originalFile.isFile()) {
			System.out.println("Ŀ���ļ����ҵ�");
			String contents = pc.readFile(originalFile);
			System.out.println("����������Ҫ���Ƶ����ļ�·��(����׺): ");
			File newFile = new File(in.nextLine());
			if(newFile.exists() && newFile.isFile()) {
				pc.writeNewFile(contents, newFile);
				System.out.println("�ļ��������");
			}else {
				System.out.println("û���ҵ���ϣ�����Ƶ��ļ�·��");
			}
		}else {
			System.out.println("û�ҵ��������ļ�");
		}
	}
	
	
	public String readFile(File file) {
		BufferedInputStream in = null;
		String result = "";
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			int d;
			
			while((d = in.read())!= -1){
				result += (char)d;
			}
			//System.out.println("�ļ�ԭ��: " + result);
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
		
		return result;
	}
	
	public void writeNewFile(String s, File file) {
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(file));
			byte[] data = s.getBytes();
			byte[] d = new byte[10*1024];
			out.write(data);
			System.out.println("д�����");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public File copyPath(String name) {
		File file = new File(name);
		
		return file;
	}
}	
