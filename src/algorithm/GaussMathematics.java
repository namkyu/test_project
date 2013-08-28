package algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @FileName : GaussMathmatics.java
 * @Project : test_project
 * @Date : 2013. 3. 8.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class GaussMathematics {

	/**
	 * <pre>
	 * gaussMathematicsTest
	 * <pre>
	 * @param startNum
	 * @param endNum
	 * @return
	 */
	public int gaussMathematicsTest(int startNum, int endNum) {
		// 예외 처리
		if (startNum == 0 || endNum == 0) {
			throw new ArithmeticException("0 값이 올 수 없습니다.");
		}

		// 마지막 수가 홀수 값이라면 저장
		int oddLastNum = 0;

		// 홀수인 경우 마지막 홀수의 값은 별도의 변수에 저장을 하고, endNum을 짝수로 바꿔준다. oddLastNum는 최종 결과 값에 더해줄 값이 된다.
		if (endNum % 2 == 1) {
			oddLastNum = endNum;
			endNum = endNum - 1;
		}

		int addResult = startNum + endNum;
		int multiplayNum = (endNum - startNum + 1) / 2;

		int result = (addResult * multiplayNum) + oddLastNum;
		return result;
	}

	@Test
	public void 정상케이스1() {
		int startNum = 1;
		int endNum = 10;
		int result = gaussMathematicsTest(startNum, endNum);
		assertThat(result, is(55));
	}

	@Test
	public void 홀수값테스트() {
		int startNum = 1;
		int endNum = 5;
		int result = gaussMathematicsTest(startNum, endNum);
		assertThat(result, is(15));
	}

	@Test
	public void 정상케이스2() {
		int startNum = 11;
		int endNum = 15;
		int result = gaussMathematicsTest(startNum, endNum);
		assertThat(result, is(65));
	}

	@Test(expected = ArithmeticException.class)
	public void 에러케이스1() {
		int startNum = 1;
		int endNum = 0;
		gaussMathematicsTest(startNum, endNum);
	}

	@Test(expected = ArithmeticException.class)
	public void 에러케이스2() {
		int startNum = 0;
		int endNum = 10;
		gaussMathematicsTest(startNum, endNum);
	}

}
