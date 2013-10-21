package date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * @FileName : LeapYear.java
 * @Project : test_project
 * @Date : 2013. 10. 21.
 * @작성자 : nklee
 * @프로그램설명 : 윤년 테스트
 */
public class LeapYear {

	@Test
	public void test() {
		assertThat(true, is(isLeapYear2(2000)));
		assertThat(false, is(isLeapYear2(2001)));
		assertThat(false, is(isLeapYear2(2002)));
		assertThat(false, is(isLeapYear2(2003)));

		assertThat(true, is(isLeapYear2(2004)));
		assertThat(false, is(isLeapYear2(2005)));
		assertThat(false, is(isLeapYear2(2006)));
		assertThat(false, is(isLeapYear2(2007)));

		assertThat(true, is(isLeapYear2(2008)));
		assertThat(false, is(isLeapYear2(2009)));
		assertThat(false, is(isLeapYear2(2010)));
		assertThat(false, is(isLeapYear(2011)));

		assertThat(true, is(isLeapYear(2012)));
		assertThat(false, is(isLeapYear(2013)));
		assertThat(false, is(isLeapYear(2014)));
		assertThat(false, is(isLeapYear(2015)));

		assertThat(false, is(isLeapYear2(1000)));
		assertThat(true, is(isLeapYear2(1200)));
	}

	/**
	 * <pre>
	 * isLeapYear
	 *
	 * <pre>
	 * @param year
	 * @return
	 */
	private boolean isLeapYear(int year) {
		GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
		return calendar.isLeapYear(year);
	}

	/**
	 * <pre>
	 * isLeapYear2
	 * 4년마다 윤년인데, 100년 마다 윤년을 제외하지만 400년 마다 윤년으로 한다.
	 *
	 * <pre>
	 * @param year
	 * @return
	 */
	private boolean isLeapYear2(int year) {
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}
}
