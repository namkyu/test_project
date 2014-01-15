package collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @FileName : JoinLists.java
 * @Project : test_project
 * @Date : 2013. 11. 4.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class JoinLists {

	@Test
	public void joinListTest() {
		List<String> listA = new ArrayList<String>();
		listA.add("A");
		listA.add("1");

		List<String> listB = new ArrayList<String>();
		listB.add("B");
		listB.add("1");

		List<String> listFinal = union(listA, listB);
		System.out.println("listA=" + listA);
		System.out.println("listB=" + listB);
		System.out.println("listFinal=" + listFinal);
	}

	/**
	 * <pre>
	 * union
	 *
	 * <pre>
	 * @param listA
	 * @param listB
	 * @return
	 */
	private List<String> union(List<String> listA, List<String> listB) {
		ArrayList<String> result = new ArrayList<String>(listA);
		result.addAll(listB);
		return result;
	}
}
