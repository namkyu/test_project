package algorithm.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : ComparatorInterfaceTest.java
 * @Project : test_project
 * @Date : 2013. 7. 19.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ComparatorInterfaceTest {

	private Map<String, String> unsortMap;

	@Before
	public void before() {
		unsortMap = new HashMap<String, String>();
		unsortMap.put("2", "B");
		unsortMap.put("1", "A");
		unsortMap.put("4", "D");
		unsortMap.put("3", "B");
		unsortMap.put("7", "C");
		unsortMap.put("5", "z");
		unsortMap.put("6", "b");
		unsortMap.put("8", "a");

//		print(unsortMap);
	}

	@Test
	public void sortTest() {
		List<Map.Entry<String, String>> list = new LinkedList<Entry<String, String>>(unsortMap.entrySet());

		// sort list based on comparator
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				System.out.println(o1.getValue() + " : " + o2.getValue());
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		Map<String, String> sortedMap = new HashMap<String, String>();
		for (Entry<String, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

//		print(sortedMap);
	}

	public static void print(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
		}
		System.out.println("");
	}
}
