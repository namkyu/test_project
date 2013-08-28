package templatecallback.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @FileName : Calculator.java
 * @Project : test_project
 * @Date : 2013. 8. 1.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Calculator {

	/**
	 * <pre>
	 * calcMultiply
	 * 곱하기
	 * <pre>
	 * @param filePath
	 * @return
	 */
	public Integer calcMultiply(String filePath) {
		BufferedReaderCallback multiplyCallback = new BufferedReaderCallback() {
			@Override
			public Integer doSomethingWithReader(String line, Integer value) {
				return value *= Integer.valueOf(line);
			}
		};

		return fileReadTemplate(filePath, multiplyCallback, 1);
	}

	/**
	 * <pre>
	 * calcSum
	 * 덧셈
	 * <pre>
	 * @param filePath
	 * @return
	 */
	public Integer calcSum(String filePath) {
		BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
			@Override
			public Integer doSomethingWithReader(String line, Integer value) {
				return value += Integer.valueOf(line);
			}
		};

		return fileReadTemplate(filePath, sumCallback, 0);
	}

	/**
	 * <pre>
	 * fileReadTemplate
	 *
	 * <pre>
	 * @param filePath
	 * @param callback
	 * @param initValue
	 * @return
	 */
	public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback, int initValue) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filePath));
			String line = null;
			Integer res = initValue;

			while ((line = br.readLine()) != null) {
				res = callback.doSomethingWithReader(line, res);
			}
			return res;

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
