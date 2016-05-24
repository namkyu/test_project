package asm;

import java.io.Serializable;
import java.util.HashMap;

public class Test extends HashMap implements Serializable {
	public static String str;
	static {
		str = "abced";
	}

	public Test() {
		super();
	}

	public static void main(String[] args) throws Exception {
		String str = "abc.dfd.efef.fjskdl";
		System.out.println(str.replace(".", "/"));
		Test test = new Test();
		String msg = "message to be printed";
		int count = 5;
		double d = 1.3;
		float f = 1.3f;
		long l = 170343702;
		HashMap map = new HashMap();
		test.printMsg(msg, count, d, f, l, map);
	}

	public void printMsg(String msg, int count, double d, float f, long l,
			HashMap map) {
		for (int i = 0; i < count; i++)
			System.out.println(msg);
	}

	public String getString(int i, String str) {
		return "abc";
	}
}