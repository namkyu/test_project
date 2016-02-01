package designpattern.async;

import lombok.Data;

import org.junit.Test;

public class FutureCallbackTest {

	@Test
	public void futureTest() throws InterruptedException {
		System.out.println("[Start Main Thread] : " + Thread.currentThread());
		Service service = new Service();
		Thread thread = service.execute(new Callback() {
			@Override
			public void doSomething(ResultData job) {
				System.out.println("[Callback resultData] : " + job);
			}
		});

		thread.join(); // main 쓰레드 종료를 막기 위해
		System.out.println("[Finished Main Thread] : " + Thread.currentThread());
	}
}


class Service {

	public Thread execute(final Callback callback) {
		final ResultData resultData = new ResultData();
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000); // 5초 sleep
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				resultData.setResult("success");
				resultData.setData("data");
				// 콜백 메서드 실행
				callback.doSomething(resultData);
			}
		};

		thread.start();
		return thread;
	}

}

interface Callback {
	public void doSomething(ResultData job);
}

@Data
class ResultData {
	private String result;
	private String data;
}
