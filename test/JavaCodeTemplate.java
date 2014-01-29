import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @FileName : JavaCodeTemplate.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class JavaCodeTemplate {

	public void specDescription() {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("test"));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}

	}

}
