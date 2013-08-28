package algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**
 * @FileName : RecursiveTest.java
 * @Project : test_project
 * @Date : 2013. 7. 5.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class RecursiveTest {

	/**
	 * <pre>
	 * recursiveFile
	 * 디렉토리 안에 있는 파일 갯수 추출
	 * <pre>
	 * @param file
	 * @param totalCnt
	 * @return
	 */
	public int recursiveFile(File file) {
		// 파일인 경우
		if (file.isFile()) {
			return 1;
		}

		int totalCnt = 0;
		String[] fileList = file.list();
		for (String childFile : fileList) {
			totalCnt += recursiveFile(new File(file, childFile));
		}

		return totalCnt;
	}

	@Test
	public void test() {
		assertThat(3, is(recursiveFile(new File("E:\\test\\recursive"))));
	}
}
