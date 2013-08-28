package collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @FileName : CollectionsTest.java
 * @Project : test_project
 * @Date : 2013. 8. 28.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class CollectionsTest {

	@Test
	public void unmodifyMapTest() {
		Map<Integer, String> testMap = new HashMap<Integer, String>();
		testMap.put(1, "test1");
		testMap.put(2, "test2");

		Map<Integer, String> unmodifyTestMap = Collections.unmodifiableMap(testMap);
		assertThat("test1", is(unmodifyTestMap.get(1)));
		assertThat("test2", is(unmodifyTestMap.get(2)));

		boolean exceptionThrown = false;
		try {
			unmodifyTestMap.put(3, "test3"); // unmodifyTestMap 객체 변경 시 예외 발생
		} catch (UnsupportedOperationException ex) {
			ex.printStackTrace();
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}
}