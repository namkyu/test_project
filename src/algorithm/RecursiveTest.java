package algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
			File childFilePath = new File(file, childFile);
			totalCnt += recursiveFile(childFilePath);
		}

		return totalCnt;
	}

	@Test
	public void test() {
		assertThat(5, is(recursiveFile(new File("E:\\test\\build"))));
	}


	@Test
	public void test2() {
		List<String> fileList = new ArrayList<>();
		fileList = recursiveTest2(fileList, new File("E:\\test\\build"));
		System.out.println(fileList);
	}

	/**
	 * <pre>
	 * recursiveTest2
	 *
	 * <pre>
	 * @param fileList
	 * @param file
	 * @return
	 */
	private List<String> recursiveTest2(List<String> fileList, File file) {

		if (file.isFile()) {
			fileList.add(file.getName());
			return fileList;
		}

		String[] fileArr = file.list();
		for (String childFile : fileArr) {
			File subFile = new File(file, childFile);
			recursiveTest2(fileList, subFile);
		}

		return fileList;
	}
}
