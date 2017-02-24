import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @FileName : CallByValueTest.java
 * @Project : test_project
 * @Date : 2012. 11. 7.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class CallByValueTest {


	/**
	 * <pre>
	 * 원시변수테스트
	 *
	 * <pre>
	 */
	@Test
	public void 원시변수테스트() {
		String str = "namkyu";
		changeObject(str);
		assertThat(str, is(str)); // call by value (namkyu == namkyu)

		int cnt = 1;
		changeObject(cnt);
		assertThat(cnt, is(cnt)); // call by value (1 == 1)

		String[] strArr = {"1", "2"};
		chageArr(strArr);
		assertThat("3", is(strArr[1])); // call by value
	}

	public static void chageArr(String[] strArr) {
		strArr[1] = "3";
	}

	/**
	 * <pre>
	 * List객체테스트
	 *
	 * <pre>
	 */
	@Test
	public void List객체테스트() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");

		changeObject(list);
		assertThat(list, is(notNullValue())); // call by value
	}

	/**
	 * <pre>
	 * VO객체테스트
	 *
	 * <pre>
	 */
	@Test
	public void VO객체테스트() {
		TestVO vo = new TestVO();
		vo.setName("kyu");

		changeObject(vo);
		assertThat(vo, is(notNullValue())); // call by value

		String name = vo.getName();
		changeVO(vo);
		assertThat(name, is(not(vo.getName()))); // call by value
	}

	public <T> void changeObject(T obj) {
		obj = null;
	}

	public void changeVO(TestVO vo) { // TestVO의 레퍼런스 변수의 값을 복제해서 넘겨준다.
		vo.setName("namkyu");
		vo = null;
	}

	class TestVO {

		private String name;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
	}
}