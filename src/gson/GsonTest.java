package gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import com.google.gson.Gson;

/**
 * @FileName : GsonTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GsonTest {

	@Test
	public void test() {

		Gson gson = new Gson();
		String json = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		Map<String, String> map = new HashMap<String, String>();
		map = (Map<String, String>) gson.fromJson(json, map.getClass());

		System.out.println(map);
	}

	@Test
	public void scannerTest() {
		Scanner in = new Scanner(System.in);

		String[] input = new String[in.nextInt()];
		in.nextLine(); //consuming the <enter> from input above

	    for (int i = 0; i < input.length; i++) {
	        input[i] = in.nextLine();
	    }

	    System.out.printf("\n Your input:\n");
	    for (String s : input) {
	        System.out.println(s);
	    }
	}
}
