package thread;

import java.util.concurrent.TimeUnit;

/**
 * @FileName : ThreadStopTEst.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ThreadStopTest {

	public static void main(String[] args) throws InterruptedException {
		Server myServer = new Server();
		Thread t1 = new Thread(myServer, "T1");
		t1.start();

		TimeUnit.SECONDS.sleep(1);

		System.out.println(Thread.currentThread().getName() + " is stopping Server Thread");
		myServer.stop();
		System.out.println(Thread.currentThread().getName() + " is finished now");
	}
}

class Server implements Runnable {

	private volatile boolean exit = false;

	/**
	 * <pre>
	 * run
	 *
	 * <pre>
	 */
	@Override
	public void run() {
		while (!exit) {
			System.out.println("Server is running.....");
		}

		System.out.println("Server is stopped.....");
	}

	public void stop() {
		exit = true;
	}
}
