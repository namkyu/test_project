package java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * @FileName : TestJava7.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class TestJava7 {

	@Test
	public void multiCatchTest() {

		try {
			new FileInputStream(new File("test"));
		} catch (ArithmeticException | IOException ex) {
			System.out.println(ex.getStackTrace());
			ex.printStackTrace();
		}
	}

	@Test
	public void multiCatchTest2() {
		try {
			new FileInputStream(new File(""));
		} catch (IOException | RuntimeException ex) {
		}

	}
}
