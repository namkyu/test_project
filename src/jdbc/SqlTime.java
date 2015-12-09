package jdbc;

import java.util.Date;

import org.junit.Test;

/**
 * @FileName : SqlTime.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class SqlTime {

	private int number = 100000000;
	private int underscoreNumber = 100_000_000;

	@Test
	public void test() {
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
	}

	@Test
	public void underscoreNumTest() {
		System.out.println(number);
		System.out.println(underscoreNumber);
	}
}
