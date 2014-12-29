package decimal;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @FileName : BigDecimalTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class BigDecimalTest {

	@Test
	public void test1() {
		double a = 1.1;
		System.out.println(a * 1000);

		double b = 31000.1034;
		System.out.println(b * 1000);

		BigDecimal c = new BigDecimal(b);
		System.out.println(b);
		System.out.println(c.multiply(new BigDecimal(1000)));
	}

}
