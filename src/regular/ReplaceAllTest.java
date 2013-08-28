package regular;

import org.junit.Test;

/**
 * @FileName : ReplaceAllTest.java
 * @Project : test_project
 * @Date : 2013. 6. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ReplaceAllTest {


	@Test
	public void spaceTest() {
		String test = "hello  test";
		System.out.println(test.replaceAll(" ", " world "));
		System.out.println(test.replaceAll("\\s+", " world "));
	}
}
