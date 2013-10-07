package sync;

import org.junit.BeforeClass;
import org.junit.Test;






/**
 * @FileName : SyncTest.java
 * @Project : test_project
 * @Date : 2012. 11. 8.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SyncTest2 {

	private static SyncTarget target;

	@BeforeClass
	public static void init() {
		target = new SyncTarget();
		System.out.println("inint");
	}

	@Test
	public void threadLockTest2() {

		for (int i = 0; i < 5; i++) {
			new Thread() {
				@Override
				public void run() {
					synchronized (target) {
						target.test2();
					}
				};
			}.start();
		}
	}

	@Test
	public void threadLockTest3() {

		for (int i = 0; i < 5; i++) {
			new Thread() {
				@Override
				public void run() {
					synchronized (target) {
						target.test3();
					}
				};
			}.start();
		}
	}

	public static class SyncTarget {

		public void test2() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test2(), threadName=" + Thread.currentThread().getName());
		}

		public void test3() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test3(), threadName=" + Thread.currentThread().getName());
		}
	}
}
