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
		System.out.println("===============================================");
	}

	@Test
	public void timeZoneTest() {
		// seoul
		TimeZone seoulTimeZone = TimeZone.getDefault();
		df.setTimeZone(seoulTimeZone);
		System.out.println(seoulTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// tokyo
		TimeZone tokyoTimeZone = TimeZone.getTimeZone("Asia/Tokyo");
		df.setTimeZone(tokyoTimeZone);
		System.out.println(tokyoTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// Los_Angeles
		TimeZone losAngelesTimeZone = TimeZone.getTimeZone("America/Los_Angeles");
		df.setTimeZone(losAngelesTimeZone);
		System.out.println(losAngelesTimeZone.getDisplayName() + " : " + df.format(new Date()));

		// bangkok
		TimeZone bangkokTimeZone = TimeZone.getTimeZone("Asia/Bangkok");
		df.setTimeZone(bangkokTimeZone);
		System.out.println(bangkokTimeZone.getDisplayName() + " : " + df.format(new Date()));

	}
}
