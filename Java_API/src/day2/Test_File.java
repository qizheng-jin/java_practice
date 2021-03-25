package day2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test_File {
	public static void main(String[] args) {
		File file = new File("test.txt");
		System.out.println(file.getAbsolutePath());
		if(file.exists()) {
			System.out.println("�ҵ��˸��ļ�");
			System.out.println("�ļ�����: " + file.length());
			System.out.println("�ļ��Ƿ�Ϊ�ļ�: " + file.isFile());
			System.out.println("�ļ��Ƿ��Ǹ��ļ���: " +file.isDirectory());
			System.out.println("�ļ���: " + file.getName());
			System.out.println("����Ŀ¼: " + file.getParent());
			System.out.println("�ļ�����·��: " + file.getAbsolutePath());
		}
		System.out.println("******************************");
		//�ļ��Ĵ�����ɾ��
		
		try {
			file = new File("create_delete.txt");
			System.out.println(file.createNewFile());
			System.out.println(file.delete());
			file = new File("Directory");
			System.out.println(file.mkdir());
			//System.out.println(file.delete());//����ļ����ǿյ�,����ɾ,�����������ɾ��ʧ��,����Ƕ����ļ���Ƕ��,��ɾ���������ļ���
			
			File[] listFile = file.listFiles();//�õ����ļ������������ļ�
			System.out.println(file.getAbsolutePath());
			System.out.println(file.isDirectory());
			System.out.println(Arrays.toString(listFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
