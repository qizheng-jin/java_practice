package day4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**�������ڲ��Ա���ת����*/
public class Test_Encode {
	//����������
	public static void main(String[] args) {
		OutputStreamWriter osw = null;
		try {
			/**
			 * 1.txt���Ǵ����ļ����µ��ļ�·��,�������·��
			 */
			osw = new OutputStreamWriter(new FileOutputStream("test.txt"));
			osw.write("��,�Է�!");
			System.out.println("��ϲ��!����ɹ�");
		}catch (IOException e) {
			System.out.println("����ʧ��");
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
