package thread;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccessMultiThreadOfHashMap {

	public static void main(String args[]) throws IOException {
		Map<String, String> testMap = new HashMap<String, String>();
		testMap.put("1", "1");
		testMap.put("2", "2");
		testMap.put("3", "3");

		Thread t1 = new Thread(new Task1(testMap));
		Thread t2 = new Thread(new Task1(testMap));
		Thread t3 = new Thread(new Task2(testMap));

		t1.start();
		t3.start();
		t2.start();
	}

	public static String threadSafeFormat(Date date) {
		DateFormat formatter = PerThreadFormatter.getDateFormatter();
		return formatter.format(date);
	}

}

class Task1 implements Runnable {

	Map<String, String> testMap;

	public Task1(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " : " + testMap.get("1"));
	}
}

class Task2 implements Runnable {

	Map<String, String> testMap;

	public Task2(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	@Override
	public void run() {
		testMap.remove("1");
	}
}
