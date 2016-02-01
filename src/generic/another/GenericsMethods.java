package generic.another;

/**
 * @FileName : GenericsMethods.java
 * @Project : test_project
 * @Date : 2016. 1. 8.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GenericsMethods {

	// Generics in method
	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
		return g1.get().equals(g2.get());
	}

	// Generics Bounded Type Parameters
	public static <T extends Comparable<T>> int compare(T t1, T t2) {
		return t1.compareTo(t2);
	}

	public static void main(String args[]) {
		GenericsType<String> g1 = new GenericsType<>();
		g1.set("Pankaj");

		GenericsType<String> g2 = new GenericsType<>();
		g2.set("Pankaj");

		boolean isEqual = GenericsMethods.<String> isEqual(g1, g2);
		System.out.println(isEqual);
		// above statement can be written simply as

		isEqual = GenericsMethods.isEqual(g1, g2);
		System.out.println(isEqual);
		// This feature, known as type inference, allows you to invoke a generic
		// method as an ordinary method, without specifying a type between angle
		// brackets.
		// Compiler will infer the type that is needed
	}
}
