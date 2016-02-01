package generic.another;

/**
 * @FileName : GenericsType.java
 * @Project : test_project
 * @Date : 2016. 1. 8.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GenericsType<T> {

	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {
		this.t = t1;
	}

	public static void main(String args[]) {
		GenericsType<String> type = new GenericsType<>();
		type.set("Pankaj"); // valid

		GenericsType type1 = new GenericsType(); // raw type
		type1.set("Pankaj"); // valid
		type1.set(10); // valid and autoboxing support
	}
}
