package algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : HangleSort.java
 * @Project : test_project
 * @Date : 2013. 6. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ProblemTest {

	private List<String> hangleList;

	@Before
	public void before() {
		hangleList = new ArrayList<String>();
		hangleList.add("가");
		hangleList.add("라");
		hangleList.add("다");
		hangleList.add("나");
	}

	@Test
	public void sortTest() {
		Collections.sort(hangleList);
		hangleList.add(0, "first");

		assertThat("first", is(hangleList.get(0)));
	}

	@Test
	public void reverseTest() {
		Collections.sort(hangleList);
		Collections.reverse(hangleList);

		assertThat("라", is(hangleList.get(0)));
		assertThat("가", is(hangleList.get(3)));
	}

	@Test
	public void primitiveSortTest() {
		String[] arr = {"1", "2", "4", "3"};
		Arrays.sort(arr);

		assertThat("1", is(arr[0]));
		assertThat("4", is(arr[3]));
	}

	@Test
	public void reversePrimitive() {
		Integer[] arr = {1, 2, 3};
		int arrLength = arr.length;

		int idx = 0;
		Integer[] resultArr = new Integer[arrLength];
		for (int i = (arrLength - 1); i >= 0; i--) {
			resultArr[idx] = arr[i];
			idx++;
		}

		assertThat(3, is(resultArr[0]));
		assertThat(2, is(resultArr[1]));
		assertThat(1, is(resultArr[2]));
	}

	@Test
	public void reverseString() {
		String test = "12345";
		int length = test.length();

		for (int i = (length - 1); i >= 0; i--) {
			System.out.println(test.charAt(i));
		}
	}

}
