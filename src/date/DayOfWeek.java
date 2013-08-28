package date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @FileName : DayOfWeek.java
 * @Project : test_project
 * @Date : 2012. 6. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DayOfWeek {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		DayOfWeek dayOfWeek = new DayOfWeek();
		dayOfWeek.getDayOfWeek("20120618");
	}

	/**
	 * <pre>
	 * getDayOfWeek
	 * 요일 추출
	 * <pre>
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public int getDayOfWeek(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date day = df.parse(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		return dayOfWeek;
	}
}
