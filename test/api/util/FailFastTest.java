package api.util;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : FailFastTest.java
 * @Project : test_project
 * @Date : 2012. 11. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FailFastTest {

	private List<Integer> testList;
	private Vector<Integer> vecList;
	private Map<Integer, Integer> mapList;

	@Before
	public void init() {
		testList = new ArrayList<Integer>();
		vecList = new Vector<Integer>();
		mapList = new Hashtable<Integer, Integer>();

		for (int i = 0; i < 1000; i++) {
			testList.add(i);
			vecList.add(i);
			mapList.put(i, i);
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void iterator테스트() throws InterruptedException {

		new AnotherThread().start();

		Iterator<Integer> it = testList.iterator();
		while (it.hasNext()) {
			Thread.sleep(10);
//			System.out.println(it.next());
		}
	}

	@Test
	public void enumeration테스트() throws InterruptedException {
		new AnotherThread().start();

		Enumeration<Integer> en = vecList.elements();
		while (en.hasMoreElements()) {
			Thread.sleep(10);
//			System.out.println(en.nextElement());
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void list테스트() throws InterruptedException {
		new AnotherThread().start();

		for (Integer element : testList) {
			Thread.sleep(10);
//			System.out.println(element);
		}
	}

	@Test
	public void vector테스트() throws InterruptedException {
		new AnotherThread().start();

		for (Integer element : vecList) {
			Thread.sleep(10);
//			System.out.println(element);
		}
	}

	@Test
	public void hashTable테스트() throws InterruptedException {
		new AnotherThread().start();

		Iterator<Entry<Integer, Integer>> it = mapList.entrySet().iterator();
		while (it.hasNext()) {
			Thread.sleep(10);
//			System.out.println(it.next());
		}
	}

	class AnotherThread extends Thread {

		@Override
		public void run() {
			System.out.println("start another thread!!");
			try {
				Thread.sleep(4000); // 4초 동안 sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			testList.remove(500); // iterator collection 객체 변경
			vecList.remove(500); // Vector collection 객체 변경
			mapList.remove(500); // HashTable collection 객체 변경
		}
	}
}
