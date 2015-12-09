package multithreadissue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * @FileName : SimpleDateFormatTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class SimpleDateFormatTest {

	static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	private SimpleDateFormat getFormat() {
		return new SimpleDateFormat("yyyyMMdd");
	}

	@Test
	public void SimpleDateFormatIsNotSafeTest() {

		// init
		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<Date>> results = new ArrayList<Future<Date>>();

		try {
			// SimpleDateFormat을 이용한 parse 작업 (멀티 쓰레드)
			Callable<Date> task = new Callable<Date>() {
				public Date call() throws Exception {
					String threadName = Thread.currentThread().getName();
					System.out.println("threadName ==> " + threadName);
					return format.parse("20150630");
//					return getFormat().parse("20150630"); // 정상 동작시키기 위해서는 이와 같이 사용해야 함
				}
			};

			// 10건 수행
			for (int i = 0; i < 10; i++) {
				results.add(exec.submit(task));
			}

			// 결과 출력
			for (Future<Date> result : results) {
				System.out.println(result.get());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			exec.shutdown();
		}

	}
}
