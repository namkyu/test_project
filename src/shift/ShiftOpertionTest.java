package shift;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @FileName : ShiftOpertionTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ShiftOpertionTest {

	/**
	 * <pre>
	 * leftShiftTest
	 * 2진 비트로 바꾼 후 왼쪽으로 특정 비트 수만큼 이동 시킴
	 * 빈자리는 0으로 채움
	 *
	 * <pre>
	 */
	@Test
	public void leftShiftTest() {
		assertThat(2, is(1 << 1));
		assertThat(4, is(2 << 1));
	}

	/**
	 * <pre>
	 * rightShiftTest
	 * 2진 비트로 바꾼 후 오른쪽으로 특정 비트 수만큼 이동 시킴
	 * 빈자리는 양수일 때 0, 음수일 때 1로 채운다.
	 *
	 * <pre>
	 */
	@Test
	public void rightShiftTest() {
		// 정수
		assertThat(256, is(512 >> 1));
		assertThat(128, is(256 >> 1));
		assertThat(64, is(128 >> 1));
		assertThat(32, is(64 >> 1));
		assertThat(16, is(32 >> 1));
		assertThat(8, is(16 >> 1));

		// 음수
		assertThat(-4, is(-8 >> 1));
		assertThat(-2, is(-4 >> 1));
		assertThat(-1, is(-2 >> 1));
	}

	public static void main(String[] args) {
		printBinaryNumber(3);
	}

	/**
	 * <pre>
	 * printBinaryNumber
	 *
	 * <pre>
	 * @param n
	 */
	private static void printBinaryNumber(int n) {
		String temp = null;
		String binaryStr = null;

		// 0을 빈자리 개수만큼 만들어 전진 배치
		for (int i = 0; i < Integer.numberOfLeadingZeros(n); i++) {
			temp += "0";
		}

		// 10진수를 2진수화하여 합치기
		temp += Integer.toBinaryString(n);

		// 2진수를 8개씩 공백으로 나누어 묶기
		for (int i = 0; i < 32; i += 8) {
			binaryStr += temp.substring(i, i + 8) + " ";
		}

		System.out.println(binaryStr);
	}
}
