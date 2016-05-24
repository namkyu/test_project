package cron;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.quartz.CronExpression;

/**
 * @FileName : CronExpressionTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class CronExpressionTest {

	@Test
	public void cronTimeTest() throws ParseException {
		// 매일 9, 12, 18시 정각에 스케줄링 동작
		String cronEx = "0 0 9,12,18 * * ?";
		CronExpression cronExpression = new CronExpression(cronEx);

		Date nextTime1 = cronExpression.getNextValidTimeAfter(new Date());
		Date nextTime2 = cronExpression.getNextValidTimeAfter(nextTime1);
		Date nextTime3 = cronExpression.getNextValidTimeAfter(nextTime2);
		Date nextTime4 = cronExpression.getNextValidTimeAfter(nextTime3);

		System.out.println(nextTime1);
		System.out.println(nextTime2);
		System.out.println(nextTime3);
		System.out.println(nextTime4);
	}

	@Test
	public void 타임테스트() throws ParseException {
		CronExpression cronExpression = new CronExpression("0 0 13 * * ?");
		Date result = cronExpression.getNextValidTimeAfter(new Date());
		System.out.println(result);

	}
}
