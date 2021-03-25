package day2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test_File {
	public static void main(String[] args) {
		File file = new File("test.txt");
		System.out.println(file.getAbsolutePath());
		if(file.exists()) {
			System.out.println("找到了该文件");
			System.out.println("文件长度: " + file.length());
			System.out.println("文件是否为文件: " + file.isFile());
			System.out.println("文件是否是个文件夹: " +file.isDirectory());
			System.out.println("文件名: " + file.getName());
			System.out.println("父级目录: " + file.getParent());
			System.out.println("文件绝对路径: " + file.getAbsolutePath());
		}
		System.out.println("******************************");
		//文件的创建和删除
		
		try {
			file = new File("create_delete.txt");
			System.out.println(file.createNewFile());
			System.out.println(file.delete());
			file = new File("Directory");
			System.out.println(file.mkdir());
			//System.out.println(file.delete());//如果文件夹是空的,才能删,如果有内容则删除失败,如果是多层空文件夹嵌套,则删除最里层的文件夹
			
			File[] listFile = file.listFiles();//得到该文件夹下面所有文件
			System.out.println(file.getAbsolutePath());
			System.out.println(file.isDirectory());
			System.out.println(Arrays.toString(listFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
