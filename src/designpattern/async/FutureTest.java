package designpattern.async;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class FutureTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		System.out.println("[Start Main Thread] : " + Thread.currentThread());
		FutureService futureService = new FutureService();
		AsyncFuture<ResponseDate> future = futureService.execute();

		ResponseDate responseData = future.get();
		System.out.println("[Response Data] : " + responseData.getData());
		System.out.println("[Finished Main Thread] : " + Thread.currentThread());
	}
}

class FutureService {

	public AsyncFuture<ResponseDate> execute() {
		final ResponseDate result = new ResponseDate();

		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					result.setData("success!!");
				} catch (InterruptedException e) {
					result.setData("fail!!");
				}
			};
		}.start();

		return new AsyncFuture<ResponseDate>(result);
	}

}

class AsyncFuture<V> {

	private final V value;

	public AsyncFuture(V value) {
		this.value = value;
	}

	public V get() {
		return this.value;
	}
}


class ResponseDate {
	private String data;
	private boolean done;

	public synchronized String getData() throws InterruptedException {
		if (done == false) {
			wait();
		}
		return this.data;
	}
	public synchronized void setData(String data) {
		if (done == false) {
			this.data = data;
			this.done = true;
			notifyAll();
		}
	}
	public boolean isDone() {
		return done;
	}
}