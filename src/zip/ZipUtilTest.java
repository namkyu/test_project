package zip;

import org.junit.Test;

/**
 * @FileName : ZipUtilTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ZipUtilTest {

	@Test
	public void unzip() throws Exception {
		ZipUtil.unzip("E:\\test\\zip\\test_project.zip", "E:\\test\\zip\\test_project");

	}
}
