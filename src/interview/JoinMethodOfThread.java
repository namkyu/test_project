package interview;

public class JoinMethodOfThread {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread is started!!");

		Thread test1 = new Thread(new JoinMethodOfThreadTest(null));
		Thread test2 = new Thread(new JoinMethodOfThreadTest(test1));
		Thread test3 = new Thread(new JoinMethodOfThreadTest(test2));

		test1.start();
		test2.start();
		test3.start();
		test3.join();

		System.out.println("main thread is done!!");
	}
}

class JoinMethodOfThreadTest implements Runnable {

	private Thread thread;

	public JoinMethodOfThreadTest(Thread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		try {
			if (thread != null) {
				thread.join();
			}
			System.out.println(Thread.currentThread().getName() + " is started!!");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " is done!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
