package api.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : MapTest.java
 * @Project : test_project
 * @Date : 2012. 10. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MapTest {

	private static Map<String, String> sortMapCheck;

	private static final String[] dataArr = new String[] { "1", "2", "3", "4", "5" };

	@Before
	public void 맵데이터생성() {
		sortMapCheck = new HashMap<String, String>();
		for (String value : dataArr) {
			sortMapCheck.put(value, value);
		}

		// 데이터 입력 갯수 검증
		assertThat(sortMapCheck.size(), is(dataArr.length));
	}

	@Test
	public void 맵순서로깅() {
		int idx = 0;

		for (Iterator<String> it = sortMapCheck.keySet().iterator(); it.hasNext();) {
			String value = dataArr[idx];
			String keyValue = it.next();

			System.out.println("value=" + value + ", keyValue=" + keyValue);
			idx++;
		}
	}

	@Test
	public void 사이즈체크() {
		assertThat(sortMapCheck.size(), is(5));
	}

	@Test
	public void empty체크() {
		assertThat(sortMapCheck.isEmpty(), is(false));
	}

	@Test
	public void get체크() {
		assertThat(sortMapCheck.get("3"), is("3"));
		assertThat(sortMapCheck.get("10"), nullValue());
	}

	@Test
	public void containKey테스트() {
		assertThat(sortMapCheck.containsKey("4"), is(true));
		assertThat(sortMapCheck.containsKey("10"), is(false));
	}

	@Test
	public void containValue테스트() {
		assertThat(sortMapCheck.containsValue("4"), is(true));
		assertThat(sortMapCheck.containsValue("10"), is(false));
	}

	@Test
	public void put테스트() {
		sortMapCheck.put("6", "6");
		assertThat(sortMapCheck.size(), is(6));
		assertThat(sortMapCheck.get("6"), is("6"));

		sortMapCheck.put("3", "33");
		assertThat(sortMapCheck.size(), is(6));
		assertThat(sortMapCheck.get("3"), is("33"));
	}

	@Test
	public void putAll테스트() {
		Map<String, String> putMap = new HashMap<String, String>();
		putMap.put("6", "6");
		putMap.put("7", "7");
		putMap.put("5", "6");
		sortMapCheck.putAll(putMap);

		assertThat(sortMapCheck.size(), is(7));
		assertThat(sortMapCheck.get("5"), is("6"));
	}

	@Test
	public void remove테스트() {
		sortMapCheck.remove("3");
		assertThat(sortMapCheck.size(), is(4));
	}

	@Test
	public void clear테스트() {
		sortMapCheck.clear();
		assertThat(sortMapCheck.size(), is(0));
	}

	@Test
	public void values테스트() {
		assertThat(sortMapCheck.values().size(), is(5));
		for (String mapValue : sortMapCheck.values()) {
			assertThat(sortMapCheck.containsValue(mapValue), is(true));
		}
	}

	@Test
	public void keySet테스트() {
		for (Iterator<String> it = sortMapCheck.keySet().iterator(); it.hasNext();) {
			assertThat(sortMapCheck.containsKey(it.next()), is(true));
		}
	}

	@Test
	public void entrySet테스트() {
		Iterator<Entry<String, String>> it = sortMapCheck.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			assertThat(sortMapCheck.containsKey(entry.getKey()), is(true));
			assertThat(sortMapCheck.containsValue(entry.getValue()), is(true));
		}
	}

	@Test
	public void clone테스트() {
		@SuppressWarnings("unchecked")
		Map<String, String> cloneMap = (Map<String, String>) ((HashMap<String, String>) sortMapCheck).clone();

		sortMapCheck.clear();

		assertThat(sortMapCheck, is(not(sameInstance(cloneMap))));
		assertThat(cloneMap.size(), is(5));
	}

	@Test(expected = NullPointerException.class)
	public void hashTable테스트() {
		Map<String, String> test = new Hashtable<String, String>();
		test.put("1", "1");
		test.put("2", "2");
		test.put("3", "3");
		test.put("4", "4");
		test.put("5", null);
	}

	@Test
	public void hashMap테스트() {
		Map<String, String> test = new HashMap<String, String>();
		test.put("1", "1");
		test.put("2", "2");
		test.put("3", "3");
		test.put("4", "4");
		test.put("5", null);
	}
}
