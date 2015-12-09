package date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

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
		int differenceDate = differenceOfDate.getDifferenceOfDate("20130819", "20151126");
		System.out.println("differenceDate : " + differenceDate);


		// 두 번째 방법
		int getDiffDate = differenceOfDate.getDiffDate("20061201", "20071225");
		System.out.println("getDiffDate : " + getDiffDate);
	}

	@Test
	public void diffDateTest() throws Exception {
		DifferenceOfDate differenceOfDate = new DifferenceOfDate();
		List<Integer> list = new ArrayList<>();

		list.add(differenceOfDate.getDiffDate("20130819", "20151126"));
		list.add(differenceOfDate.getDiffDate("20120101", "20130817"));
		list.add(differenceOfDate.getDiffDate("20090113", "20120101"));
		list.add(differenceOfDate.getDiffDate("20080407", "20081206"));
		list.add(differenceOfDate.getDiffDate("20080224", "20080407"));
		list.add(differenceOfDate.getDiffDate("20080103", "20080224"));
		list.add(differenceOfDate.getDiffDate("20071225", "20080103"));
		list.add(differenceOfDate.getDiffDate("20061201", "20071225"));

		int total = 0;
		for (Integer result : list) {
			System.out.println(result);
			total += result;
		}

		System.out.println("total : " + total);
		System.out.println(total / 365 + "years " + total % 365 + "days");
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
