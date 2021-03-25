import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * 复制文件,记得关流!!!!
 *
 */
public class CopyFile {
	public static void copy(File from, File to) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(from));
			bos = new BufferedOutputStream(new FileOutputStream(to));
			byte[] data = new byte[8*1024];
			int len;
			while((len=bis.read(data))!=-1) {
				bos.write(data, 0, len);
				String s = new String(data, "UTF-8");
				System.out.println(s);
			}
			System.out.println("文件复制完毕");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File fileFrom = new File("copy_from.txt");
		File fileTo = new File("copy_to.txt");
		
		copy(fileFrom, fileTo);
	}
}
