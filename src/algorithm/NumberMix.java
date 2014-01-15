package algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @FileName : NumberMix.java
 * @Project : test_project
 * @Date : 2013. 10. 17.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class NumberMix {

	int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	@Test
	public void numberMixTest() {
		for (int i = 0; i < number.length; i++) {
			int randomNum = getRandomNumber();
			int temp = number[randomNum];
			number[randomNum] = number[i];
			number[i] = temp;
		}

		String mixedNum = Arrays.toString(number);
		System.out.println(mixedNum);
	}

	/**
	 * <pre>
	 * getRandomNumber
	 *
	 * <pre>
	 * @return
	 */
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}

	/**
	 * <pre>
	 * randomTest
	 *
	 * <pre>
	 */
	@Test
	@Ignore
	public void randomTest() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.print(random.nextInt() + ", ");
		}

		System.out.println("");
		for (int i = 0; i < 100; i++) {
			System.out.print(random.nextInt(10) + ", ");
		}
	}
}
