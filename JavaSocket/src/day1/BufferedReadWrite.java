package day1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class BufferedReadWrite {
	
	private static void method() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
			String line;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void method2(String s) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("test.txt"));
			writer.println(s);
			writer.write("½áÊø");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			writer.close();
		}
		
	}
	
	public static void main(String[] args) {
		
		method2("Ehero FlashMan");
		method2("Ehero SkyMan");
		method();
	}
}
