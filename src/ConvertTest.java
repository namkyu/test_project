import java.text.NumberFormat;
import java.text.ParseException;

import org.junit.Test;


/**
 * @FileName : ConvertTest.java
 * @Project : test_project
 * @Date : 2013. 7. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ConvertTest {

	@Test
	public void convert1() {
		String bigNumber = "1234567899";
		long result = Long.valueOf(bigNumber);
		System.out.println("convert1=" + result);
	}

	@Test
	public void convert2() throws ParseException {
		String bigNumber = "1,234,567,899";
		NumberFormat format = NumberFormat.getInstance();
		Number number = format.parse(bigNumber);
		long result = number.longValue();
		System.out.println("convert2=" + result);
	}
}
