package algorithm;

import org.junit.Test;


/**
 * @FileName : AlgorithmOExpression.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class AlgorithmOExpression {

	// O(1) 성능을 가진 함수
	public boolean isNull(String data) {
		if (data ==  null) {
			return true;
		} else {
			return false;
		}
	}

	// O(300) 성능을 가진 함수
	public int getSum(int max) {
		int data = 0;
		for (int i = 1; i <= 100; i++) { // 1
			data = data + 1; // 2
			if (data > max) { // 3
				return data;
			}
		}

		return data;
	}

	// O(4N) 성능을 가진 함수
	public int sumofArray(Integer[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) { // 1
			data[i] = data[i] + 2; // 2
		}

		for (int j = 0; j < data.length; j++) { // 3
			sum = sum + data[j]; // 4
		}

		return sum;
	}

	// O(N제곱) 성능을 가진 함수
	public int sumNested(Integer[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) { // 1
			for (int j = 0; j < data.length; j++) { // 2
				sum = sum + data[i] / 2; // 3
			}
		}

		return sum;
	}

	@Test
	public void test1() {
		System.out.println(getSum(10) * 3);
		System.out.println(getSum(100) * 3);
		System.out.println(getSum(101) * 3);
	}

	@Test
	public void test2() {
		Integer[] arr = new Integer[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		System.out.println("O(4N) : " + sumofArray(arr));
		System.out.println("O(N제곱) : " + sumNested(arr));
	}
}
