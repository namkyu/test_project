package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @FileName : PrintDuplicatedCharacter.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class PrintDuplicatedCharacter {


	public static void main(String[] args) {
		printDupl("nann");
	}

	/**
	 * <pre>
	 * printDupl
	 *
	 * <pre>
	 * @param string
	 */
	private static void printDupl(String str) {
		char[] charArr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : charArr) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
        	if (entry.getValue() > 1) {
        		System.out.printf("%s : %d개 %n", entry.getKey(), entry.getValue());
        	}
		}
	}
}
