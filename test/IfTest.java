import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @FileName : IfTest.java
 * @Project : test_project
 * @Date : 2012. 11. 1.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class IfTest {

	@Test
	public void if테스트() {
		boolean isSuccess = false;
		isSuccess = userIdCheck(); // 실패 return

		if (isSuccess = false) {
			assertThat(isSuccess, is(false));
		} else {
			fail("failed test case!!");
		}

	}

	public boolean userIdCheck() {
		return false;
	}
}
