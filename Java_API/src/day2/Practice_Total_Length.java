package day2;

import java.io.File;

public class Practice_Total_Length {
	public int totalLength(File file) {
		int length = 0;
		File[] fileList = file.listFiles();
		for(File f : fileList) {
			if(f.isDirectory()) {
				length += totalLength(f);
			}
			if(f.isFile()) {
				System.out.println(f.getAbsolutePath());
				length += f.length();
			}
		}
		return length;
	}
	
	public static void main(String[] args) {
		Practice_Total_Length ptl = new Practice_Total_Length();
		File file = new File("D:\\test");
		System.out.println(ptl.totalLength(file));
	}
}
