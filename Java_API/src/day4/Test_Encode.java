package day4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**本类用于测试编码转化流*/
public class Test_Encode {
	//创建流对象
	public static void main(String[] args) {
		OutputStreamWriter osw = null;
		try {
			/**
			 * 1.txt不是磁盘文件夹下的文件路径,而是相对路径
			 */
			osw = new OutputStreamWriter(new FileOutputStream("test.txt"));
			osw.write("冲,吃饭!");
			System.out.println("恭喜您!输入成功");
		}catch (IOException e) {
			System.out.println("输入失败");
			e.printStackTrace();
		}finally {
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
