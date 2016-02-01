package generic.another;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName : Test.java
 * @Project : test_project
 * @Date : 2016. 1. 11.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class Test {

	@org.junit.Test
	public void test1() {
		Set setOfRawType = new HashSet<String>();
	}

	@org.junit.Test
	public void test2() {
		HashSet<? extends Number> setData = new HashSet<Integer>();
		setData = new HashSet<Float>();
		setData = new HashSet<Double>();
		// setData = new HashSet<String>(); // comile error
	}

	@org.junit.Test
	public void test3() {

	}

	public static <T> T identical(T t) {
		return null;
	}

	public static <T> T identical() {
		return null;
	}

	@org.junit.Test
	public void test4() {
		Holder<String> test = new Holder<>(200);
		test.add("1010");
		System.out.println(test.get(0));
	}

	@org.junit.Test
	public void test5() {

	}

}

class Holder<T> {

	private T[] contents;
	private int index = 0;

	public Holder(int size) {
		// contents = new T[size]; // compiler error - Cannot create a generic
		// array of T
		contents = (T[]) new Object[size];
	}

	public void add(T content) {
		contents[index] = content;
	}

	public T get(int index) {
		return contents[index];
	}

}

class Holder2<T> {
	private T[] contents;

	private <U> U[] toArray(U[] a) {
		return null;
	}
}
