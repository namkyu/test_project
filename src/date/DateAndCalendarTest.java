package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * @FileName : DateAndCalendarTest.java
 * @Project : test_project
 * @Date : 2013. 10. 23.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class DateAndCalendarTest {

	@Test
	public void dateTest1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		System.out.println(date);
	}

	@Test
	public void dateTest2() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		String dateInString = "20131023 14:20:12";
		Date date = sdf.parse(dateInString);
		System.out.println(date);
	}

	@Test
	public void dateTest3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
	}

	@Test
	public void calendarTest1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 0, 31);
		System.out.println(sdf.format(calendar.getTime()));
	}

	@Test
	public void calendarTest2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 1, 28, 10, 20, 30);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR); // 12 hour clock
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		System.out.println(sdf.format(calendar.getTime()));

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);
	}

	@Test
	public void calendarTest3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 1, 28, 10, 20, 30);
		System.out.println("#1. " + sdf.format(calendar.getTime()));

		// update a date
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONDAY, 11);
		calendar.set(Calendar.MINUTE, 33);
		System.out.println("#2. " + sdf.format(calendar.getTime()));
	}

	@Test
	public void calendarTest4() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar(2013, 1, 28);
		System.out.println("Date : " + sdf.format(calendar.getTime()));

		// add one month
		calendar.add(Calendar.MONDAY, 1);
		System.out.println("Date : " + sdf.format(calendar.getTime()));

		// subtract 10 days
		calendar.add(Calendar.DAY_OF_MONTH, -10);
		System.out.println("Date : " + sdf.format(calendar.getTime()));
	}
}
