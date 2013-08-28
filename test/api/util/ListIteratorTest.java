package api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : ListIteratorTest.java
 * @Project : test_project
 * @Date : 2012. 11. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ListIteratorTest {

	private List<Integer> testList;

	@Before
	public void init() {
		testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
	}


	@Test
	public void previousTest() {
		ListIterator<Integer> it = testList.listIterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		while (it.hasPrevious()) {
			System.out.println(it.previous());
		}

	}
}
