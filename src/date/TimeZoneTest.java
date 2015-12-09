package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : TimeZoneTest.java
 * @Project : test_project
 * @Date : 2013. 9. 13.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class TimeZoneTest {

	private DateFormat df;

	@Before
	public void init() {
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");
		System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
	}

	@Test
	public void timeZoneTest() {

		System.out.println("====================================================");
		System.out.println("America");
		System.out.println("====================================================");

		// local time zone
		TimeZone localTimeZone = TimeZone.getDefault();
		df.setTimeZone(localTimeZone);
		System.out.println(localTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// Los_Angeles
		TimeZone losAngelesTimeZone = TimeZone.getTimeZone("America/Los_Angeles");
		df.setTimeZone(losAngelesTimeZone);
		System.out.println(losAngelesTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// New_York
		TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
		df.setTimeZone(newYorkTimeZone);
		System.out.println(newYorkTimeZone.getDisplayName() + " : " + df.format(new Date()));

		System.out.println("====================================================");
		System.out.println("Asia");
		System.out.println("====================================================");

		// seoul
		TimeZone seoulTimeZone = TimeZone.getTimeZone("Asia/Seoul");
		df.setTimeZone(seoulTimeZone);
		System.out.println(seoulTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// tokyo
		TimeZone tokyoTimeZone = TimeZone.getTimeZone("Asia/Tokyo");
		df.setTimeZone(tokyoTimeZone);
		System.out.println(tokyoTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// bangkok
		TimeZone bangkokTimeZone = TimeZone.getTimeZone("Asia/Bangkok");
		df.setTimeZone(bangkokTimeZone);
		System.out.println(bangkokTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// Hong_Kong
		TimeZone hongKongTimeZone = TimeZone.getTimeZone("Asia/Hong_Kong");
		df.setTimeZone(hongKongTimeZone);
		System.out.println(hongKongTimeZone.getDisplayName() + " : " + df.format(new Date()));

	}
}
