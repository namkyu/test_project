package generic.another;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {

	@org.junit.Test
	public void specDescription() {
		ArrayGenericType<String> arrObj = new ArrayGenericType<String>(10);
		String[] strArr = new String[]{"1", "2"};
		System.out.println(Arrays.toString(arrObj.test(strArr)));
	}
}

class ClassGenericType<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}

interface InterfaceGenericType<T1, T2> {
	T1 doSomething(T2 t);
	T2 doSomething2(T1 t);
}

class InterfaceGenericTypeImpl implements InterfaceGenericType<String, Integer> {
	@Override
	public String doSomething(Integer t) {
		return null;
	}

	@Override
	public Integer doSomething2(String t) {
		return null;
	}
}

class MethodGenericType {
	public static <T> int methodGeneric(T[] list, T item) {
		int count = 0;
		for (T t : list) {
			if (item == t) {
				count++;
			}
		}
		return count;
	}

	public static <T> int methodGeneric(T item) {
		return 0;
	}
}

class ArrayGenericType<T> {
	private T[] contents;
	public ArrayGenericType(int size) {
		contents = (T[]) new String[size];
	}

	public <T> T[] test(T[] arr) {
		return arr;
	}
}



class WildcardGenericType {

	public List<? extends Number> method1() {
		return new ArrayList<Long>();
	}

	// Bounded wildcard parameterized type
	public <T> List<? extends String> method2(T param) {
		return new ArrayList<String>();
	}

	// Unbounded wildcard parameterized type
	public List<?> method3() {
		return new ArrayList<>();
	}
}

class NotAllowedGenericType<T> {

	// static 필드는 제너릭 타입을 가질 수 없음
//	private static T t;

	public NotAllowedGenericType() {
		// T type은 인스턴스로 생성할 수 없음
//		new T();

		// primitives 타입으로 제너릭 타입을 선언할 수 없음
//		List<int> list = new ArrayList<>();
	}
}