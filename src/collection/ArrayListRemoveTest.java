package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @FileName : ArrayListRemoveTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ArrayListRemoveTest {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		System.out.println("before : " + numbers);

		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
			Integer number = it.next();

			if (number % 2 ==0) {
//				numbers.remove(number);
				it.remove();
			}
		}
		System.out.println("after : " + numbers);
	}
}
