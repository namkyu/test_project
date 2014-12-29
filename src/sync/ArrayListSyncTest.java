package sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @FileName : ArrayListSyncTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ArrayListSyncTest {

	// An ArrayList which is not synchronize
	static List<String> listOfSymbols = new ArrayList<String>();

	public static void main(String[] args) throws InterruptedException {
		listOfSymbols.add("A");
		listOfSymbols.add("B");
		listOfSymbols.add("C");
		listOfSymbols.add("D");
		listOfSymbols.add("E");
		listOfSymbols = Collections.synchronizedList(listOfSymbols);

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					listOfSymbols.add(String.valueOf(i));
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				// synchronized 블럭이 없으면 Exception in thread "main" java.util.ConcurrentModificationException 예외가 발생한다.
				synchronized (listOfSymbols) {
					Iterator<String> myIterator = listOfSymbols.iterator();

					while (myIterator.hasNext()) {
						System.out.println(myIterator.next());
					}
				}
			}
		}).start();
	}
}
