import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputText {
	
	public static void method() {
		File file = new File("test.txt");
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int getLen = 0;
			int readLen = 0;
			byte[] data = new byte[8192];
			while(getLen<8192) {
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
