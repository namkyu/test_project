package algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @FileName : Problem369.java
 * @Project : test_project
 * @Date : 2013. 6. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Problem369 {

	@Test
	public void test() {
		assertThat(1, is(catch369NumCnt(3)));
		assertThat(2, is(catch369NumCnt(36)));
		assertThat(3, is(catch369NumCnt(369)));
		assertThat(4, is(catch369NumCnt(3333)));
		assertThat(4, is(catch369NumCnt(3133687)));
	}

	/**
	 * <pre>
	 * catch369NumCnt
	 *
	 * <pre>
	 * @param num
	 * @return
	 */
	public static int catch369NumCnt(int num) {
		int[] checkArr = {3, 6, 9};
		int catchCnt = 0;

		do {
			// 마지막 자리 정수 값 추출
			int lastIdxNum = num % 10;

			// 3, 6, 9 숫자에 걸리는 값이 있는지 체크
			for (int i = 0; i < checkArr.length; i++) {
				if (lastIdxNum == checkArr[i]) {
					catchCnt++;
					break;
				}
			}

			// 마지막 자리 정수 값을 자르기 위해서 10으로 나눈 몫을 저장한다.
			num = num / 10;

		} while (num > 0);

		return catchCnt;
	}
}
