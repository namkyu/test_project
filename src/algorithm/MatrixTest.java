package algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : MatrixTest1.java
 * @Project : test_project
 * @Date : 2013. 5. 8.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MatrixTest {

	@Before
	public void line() {
		System.out.println("========================================");
	}

	/**
	 * <pre>
	 * metrixCase1
	 * 2차원 배열 (순차 증가)
	 *
	 * 1	2	3	4	5
	   6	7	8	9	10
	   11	12	13	14	15
	   16	17	18	19	20
	   21	22	23	24	25
	 *
	 * <pre>
	 */
	@Test
	public void matrixCase1() {
		int incValue = 0;
		Integer[][] arr = new Integer[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				incValue =+ incValue + 1;
				arr[i][j] = incValue;
			}
		}

		resultLog(arr);

		assertThat(3, is(arr[0][2]));
		assertThat(9, is(arr[1][3]));
		assertThat(25, is(arr[4][4]));
		assertThat(12, is(not(arr[1][3])));
	}

	/**
	 * <pre>
	 * metrixCase2
	 *
	 * <pre>
	 */
	@Test
	public void matrixCase2() {
		Integer[][] arr = new Integer[5][5];
		int switchValue = 0;
		int incValue = 0;

		for (int i = 0; i < 5; i++) {
			if (switchValue == 0) {
				for (int j = 0; j < 5; j++) {
					incValue =+ incValue + 1;
					arr[i][j] = incValue;
					switchValue = 1;
				}
			} else {
				for (int k = 4; k > -1; k--) {
					incValue =+ incValue + 1;
					arr[i][k] = incValue;
					switchValue = 0;
				}
			}
		}

		resultLog(arr);
		assertThat(13, is(arr[2][2]));
	}

	/**
	 * <pre>
	 * matrixCase3
	 * 대각선 알고리즘
	 * <pre>
	 */
	@Test
	public void matrixCase3() {
		int incValue = 0;
		Integer[][] arr = new Integer[5][5];

		for (int i = 0; i < 9; i++) { // 회전수 loop
			for (int j = 0; j < 5; j++) { // 대각선으로 채워야 하는 최대 column 수
				int columnIdx = i - j;

				if (columnIdx >= 0 && columnIdx <= 4) {
					incValue =+ incValue + 1;
					arr[j][columnIdx] = incValue;
				}
			}
		}

		resultLog(arr);
	}

	/**
	 * <pre>
	 * matrixCase4
	 * 달팽이 알고리즘
	 * <pre>
	 */
	@Test
	public void matrixCase4() {


	}

	/**
	 * <pre>
	 * resultLog
	 *
	 * <pre>
	 * @param arr
	 */
	private void resultLog(Integer[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.format("%s\t", arr[i][j]);
			}
			System.out.println("");
		}
	}
}
