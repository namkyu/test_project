package guava;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

/**
 * @FileName : GuavaIOTest.java
 * @Project : test_project
 * @Date : 2013. 9. 16.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GuavaIOTest {

	private String TEST_DIRECTORY;

	@Before
	public void init() {
		TEST_DIRECTORY = "E:\\test\\guava\\file\\";
	}

	@Test
	public void IOTest() throws IOException {
		File file = new File(TEST_DIRECTORY, "test.txt");
		List<String> result = Files.readLines(file, Charsets.UTF_8);
		assertThat(5, is(result.size()));

		File fromFile = new File(TEST_DIRECTORY, "test.txt");
		File toFile = new File(TEST_DIRECTORY, "move.txt");
		Files.copy(fromFile, toFile);
	}

	public List<String> readLines(File file) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}

		try {
			List<String> result = Lists.newArrayList();
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				result.add(line);
			}
			return result;

		} finally {
			reader.close();
		}
	}
}
