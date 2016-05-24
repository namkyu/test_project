package sync;

import java.util.concurrent.Semaphore;

/**
 * @FileName : MutexTest.java
 * @Project : test_project
 * @Date : 2016. 3. 25.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class MutexTest {

	private int value;
	private Semaphore mutex = new Semaphore(1);

	public int getNextValue() {
		try {
			mutex.acquire();
			value++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}

		return value;
	}

	public static void main(String[] args) {
		final MutexTest mutexTest = new MutexTest();

		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					while (true) {
						System.out.println(mutexTest.getNextValue());
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
		}
	}
}

