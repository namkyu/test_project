package generic.another;

/**
 * @FileName : GenericsTypeOld.java
 * @Project : test_project
 * @Date : 2016. 1. 8.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GenericsTypeOld {

	private Object t;

	public Object get() {
		return t;
	}

	public void set(Object t) {
		this.t = t;
	}

	public static void main(String args[]) {
		GenericsTypeOld type = new GenericsTypeOld();
		type.set("Pankaj");
		String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
		System.out.println(str);
	}
}
