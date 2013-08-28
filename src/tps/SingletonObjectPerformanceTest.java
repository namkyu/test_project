package tps;

import java.math.BigDecimal;

/**
 * @FileName : SingletonObjectPerformanceTest.java
 * @Project : test_project
 * @Date : 2013. 2. 21.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SingletonObjectPerformanceTest {

	public static void main(String[] args) throws InterruptedException {
		final Singleton singleton = new Singleton();
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					callPrototype();
				};
				// call 싱글톤
				public void callSingleton() {
					singleton.test();
				}
				// call prototype
				public void callPrototype() {
					Prototype prototype = new Prototype();
					prototype.test();
				}
			};

			t.start();
			t.join();
		}

		long endTime = System.currentTimeMillis();
		double completeTime = endTime - startTime;

		BigDecimal resuleTime = new BigDecimal(completeTime).divide(new BigDecimal(1000));
		System.out.println("complete time : " + resuleTime.toString() + "초");
	}
}

class Singleton {

	private String variable1;
	private String variable2;
	private String variable3;
	private String variable4;
	private String variable5;
	private String variable6;
	private String variable7;
	private String variable8;
	private String variable9;
	private String variable10;

	public void test() {
		System.out.println("singleton!!");
	}

	public void test1() {
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
	}
}

class Prototype {

	private String variable1;
	private String variable2;
	private String variable3;
	private String variable4;
	private String variable5;
	private String variable6;
	private String variable7;
	private String variable8;
	private String variable9;
	private String variable10;

	public void test() {
		System.out.println("prototype!!");
	}

	public void test1() {
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
		System.out.println("test메소드 입니다.");
	}
}
