package templatecallback.file;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : TemplateCallbackTest.java
 * @Project : test_project
 * @Date : 2013. 8. 1.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class TemplateCallbackTest {

	private Calculator calculator;
	private String filePath;

	@Before
	public void init() {
		calculator = new Calculator();
		filePath = "E:\\test\\templetecallback\\cal.txt";
	}

	@Test
	public void 곱하기테스트() {
		int result = calculator.calcMultiply(filePath);
		assertThat(120, is(result));
	}

	@Test
	public void 더하기테스트() {
		int result = calculator.calcSum(filePath);
		assertThat(15, is(result));
	}
}
