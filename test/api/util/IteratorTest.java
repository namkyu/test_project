package api.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : IteratorTest.java
 * @Project : test_project
 * @Date : 2012. 11. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class IteratorTest {

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
	public void 반복문() {
		int idx = 1;
		for (Iterator<Integer> it = testList.iterator(); it.hasNext();) {
			assertThat(it.next(), is(idx));
			idx++;
		}
	}

	@Test
	public void removeTest() {
		Iterator<Integer> it = testList.iterator();
		while (it.hasNext()) {
			Integer num = it.next();
			if (num == 1 || num == 3) {
				it.remove();
			}
		}
	}
}
