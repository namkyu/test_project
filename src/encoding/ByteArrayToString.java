package encoding;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * @FileName : ByteArrayToString.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ByteArrayToString {

	@Test
	public void readFile() throws Exception {
		System.out.println("java platform encoding : " + System.getProperty("file.encoding"));
		FileInputStream fis = new FileInputStream("test.xml");
		byte[] fileData = IOUtils.toByteArray(fis);
		String str = new String(fileData, StandardCharsets.UTF_8);
		System.out.println(str);
	}

}
