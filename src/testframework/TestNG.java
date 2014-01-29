package testframework;

import org.testng.annotations.Test;



/**
 * @FileName : TestNG.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class TestNG {

	@Test(invocationCount = 10, threadPoolSize = 10)
	public void test() {
		System.out.format("Thread Id : %s%n", Thread.currentThread().getId());
	}
}
