package api.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @FileName : LinkedHashMapTest.java
 * @Project : test_project
 * @Date : 2012. 10. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LinkedHashMapTest {

	private static Map<String, String> sortMapCheck;

	private static final String[] dataArr = new String[] { "1", "2", "3", "4", "5" };

	@BeforeClass
	public static void 맵데이터생성() {
		sortMapCheck = new LinkedHashMap<String, String>();
		for (String value : dataArr) {
			sortMapCheck.put(value, value);
		}

		// 데이터 입력 갯수 검증
		assertThat(sortMapCheck.size(), is(dataArr.length));
	}

	@Before
	public void 맵순서로깅() {
		int idx = 0;
		Iterator<String> it = sortMapCheck.keySet().iterator();

		while (it.hasNext()) {
			String value = dataArr[idx];
			String keyValue = it.next();

			System.out.println("value=" + value + ", keyValue=" + keyValue);
			idx++;
		}
	}

	@Test
	public void 맵데이터순서검증() {
		int idx = 0;
		Iterator<String> it = sortMapCheck.keySet().iterator();

		while (it.hasNext()) {
			String value = dataArr[idx];
			String keyValue = it.next();

			assertThat(value, is(keyValue));
			idx++;
		}
	}
}
