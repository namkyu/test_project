package api.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @FileName : ArraysTest.java
 * @Project : test_project
 * @Date : 2012. 11. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ArraysTest {

	@Test
	public void asListTest() {
		List<String> list = Arrays.asList(new String("1"), new String("2"), new String("3"));
		assertThat(list.size(), is(3));
	}

	@Test
	public void binarySearchTest() {
		byte[] bt = new String("12345678").getBytes();
		int result = 0;
		// binarySearch 메소드 사용 시 첫 번째 byte[] 파라미터는 꼭 정렬이 되어 있어야 한다.
		result = Arrays.binarySearch(bt, (byte) '1');
		assertThat(result, is(0));

		Arrays.sort(bt); // 정렬
		result = Arrays.binarySearch(bt, (byte) '8');
		assertThat(result, is(7));

		Arrays.sort(bt);
		result = Arrays.binarySearch(bt, 2, 6, (byte) '6');
		assertThat(result, is(5));


		ArraysTestObj[] objs = {new ArraysTestObj("1"), new ArraysTestObj("2"), new ArraysTestObj("3")};
		result = Arrays.binarySearch(objs, "2");
		assertThat(result, is(1));
	}

	@Test
	public void copyOfTest() {
		String[] strArr = {"1", "2", "3"};
		String[] resultArr = Arrays.copyOf(strArr, 4);
		assertThat(resultArr.length, is(4));
	}

	@Test
	public void copyOfRangeTest() {
		String[] strArr = {"1", "2", "3"};
		String[] resultArr = Arrays.copyOfRange(strArr, 1, 6);
		assertThat(resultArr.length, is(5));
	}

	@Test
	public void equalsTest() {
		String[] strArr1 = {"1", "2", "3", "4", "5"};
		String[] strArr2 = {"5", "2", "3", "1", "4"};

		boolean isEqual = false;
		isEqual = Arrays.equals(strArr1, strArr2);
		assertThat(isEqual, is(false));

		Arrays.sort(strArr1);
		Arrays.sort(strArr2);
		isEqual = Arrays.equals(strArr1, strArr2);
		assertThat(isEqual, is(true));

		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");

		List<String> list2 = new ArrayList<String>();
		list2.add("5");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("1");

		Object[] listArr1 = list1.toArray();
		Object[] listArr2 = list2.toArray();
		isEqual = Arrays.equals(listArr1, listArr2);
		assertThat(isEqual, is(false));

		Arrays.sort(listArr1);
		Arrays.sort(listArr2);

		isEqual = Arrays.equals(listArr1, listArr2);
		assertThat(isEqual, is(true));
	}

	@Test
	public void fillTest() {
		String[] strArr = {"1", "2", "3"};

		Arrays.fill(strArr, "1");
		assertThat(strArr[0], is("1"));
		assertThat(strArr[1], is("1"));
		assertThat(strArr[2], is("1"));
	}

	class ArraysTestObj implements Comparable<String> {
		private String name;

		public ArraysTestObj(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(String str) {
			return name.compareTo(str);
		}
	}

}
