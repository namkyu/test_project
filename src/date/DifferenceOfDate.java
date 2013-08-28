package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @FileName : DifferenceOfDate.java
 * @Project : test_project
 * @Date : 2012. 6. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DifferenceOfDate {

	public static void main(String[] args) throws Exception {
		DifferenceOfDate differenceOfDate = new DifferenceOfDate();

		// 첫 번째 방법
		int differenceDate = differenceOfDate.getDifferenceOfDate("20120614", "20120618");
		System.out.println("differenceDate : " + differenceDate);

		// 두 번째 방법
		int getDiffDate = differenceOfDate.getDiffDate("20120614", "20120618");
		System.out.println("getDiffDate : " + getDiffDate);

	}

	/**
	 * <pre>
	 * getDiffDate
	 *
	 * <pre>
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	private int getDiffDate(String startDate, String endDate) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date start = format.parse(startDate);
		Date end = format.parse(endDate);
		long startCurTime = start.getTime();
		long endCurTimeTemp = end.getTime();
		long diffDate = endCurTimeTemp - startCurTime;

		int result = (int) (diffDate / 86400000);
		return result;
	}

	/**
	 * <pre>
	 * getDifferenceOfDate
	 *
	 * <pre>
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int getDifferenceOfDate(String startDate, String endDate) {
		Calendar calStartDate = Calendar.getInstance();
		calStartDate.set(Calendar.YEAR, getYear(startDate));
		calStartDate.set(Calendar.MONTH, getMonth(startDate));
		calStartDate.set(Calendar.DATE, getDay(startDate));

		Calendar calEndDate = Calendar.getInstance();
		calEndDate.set(Calendar.YEAR, getYear(endDate));
		calEndDate.set(Calendar.MONTH, getMonth(endDate));
		calEndDate.set(Calendar.DATE, getDay(endDate));

		Date dateS = calStartDate.getTime();
		Date dateE = calEndDate.getTime();

		long betweenTime = dateE.getTime() - dateS.getTime();
		int result = (int) (betweenTime / 86400000);

		return result;
	}

	/**
	 * <pre>
	 * getYear
	 *
	 * <pre>
	 * @param date
	 * @return
	 */
	public int getYear(String date) {
		String month = date.substring(0, 4);
		return Integer.parseInt(month);
	}

	/**
	 * <pre>
	 * getMonth
	 *
	 * <pre>
	 * @param date
	 * @return
	 */
	public int getMonth(String date) {
		String month = date.substring(4, 6);
		return Integer.parseInt(month);
	}

	/**
	 * <pre>
	 * getDay
	 *
	 * <pre>
	 * @param date
	 * @return
	 */
	public int getDay(String date) {
		String month = date.substring(6, 8);
		return Integer.parseInt(month);
	}

}
