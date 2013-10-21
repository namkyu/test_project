package date;

import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.junit.Test;

/**
 * @FileName : JodaLibraryTest.java
 * @Project : test_project
 * @Date : 2013. 10. 21.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class JodaLibraryTest {

	@Test
	public void jodaTest() {
		DateTime dt = new DateTime();
		String monthName = dt.monthOfYear().getAsText();
		String koreaShortName = dt.monthOfYear().getAsShortText(Locale.US);
		boolean isLeapYear = dt.year().isLeap();
		System.out.println("monthName=" + monthName + ", koreaShortName=" + koreaShortName + ", isLeapYear=" + isLeapYear);

		String dayName = dt.dayOfMonth().getAsText();
		String hourName = dt.hourOfDay().getAsText();
		String secondName = dt.secondOfMinute().getAsText();
		String secondName2 = dt.secondOfDay().getAsText();
		System.out.println("dayName=" + dayName + ", hourName=" + hourName + ", secondName=" + secondName + ", secondName2=" + secondName2);
	}

	@Test
	public void timeZoneTest() {
		DateTimeZone zone = DateTimeZone.getDefault();
		Chronology gregorianJuian = GJChronology.getInstance(zone);
		DateTime dt = new DateTime(gregorianJuian);
		System.out.println(dt.getHourOfDay() + " : " + dt.getMinuteOfHour());

		zone = DateTimeZone.forID("America/Los_Angeles");
		gregorianJuian = GJChronology.getInstance(zone);
		dt = new DateTime(gregorianJuian);
		System.out.println(dt.getHourOfDay() + " : " + dt.getMinuteOfHour());
	}
}
