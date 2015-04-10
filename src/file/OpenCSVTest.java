package file;

import java.util.Arrays;

import org.junit.Test;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVReadProc;
import au.com.bytecode.opencsv.CSVRuntimeException;

/**
 * @FileName : OpenCSVTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class OpenCSVTest {

	private static final CSV csv = CSV
            .separator(',')
            .quote('\'')
            .skipLines(0)
            .charset("UTF-8")
            .create();

	@Test
	public void csv파일read() throws CSVRuntimeException {
		csv.read("E:\\test\\file\\csv\\csv.txt", new CSVReadProc() {

			@Override
			public void procRow(int rowIndex, String... values) {
				System.out.println("rowIndex=" + rowIndex + ", values=" + Arrays.toString(values));
			}
		});


	}
}
