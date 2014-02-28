package generic;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * @FileName : GenericTest.java
 * @Project : test_project
 * @Date : 2012. 10. 12.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class GenericTest {

	private final String ID = "lng";
	private final String PW = "1234";

	@Test
	public void logTest() {
		log("msg");
		log(11231);
		log(4.12121);
		log(10L);
	}

	public <T> void log(T msg) {
		System.out.println(msg);
	}

	@Test
	public void 타입테스트() {
		Type<String> type = new Type<String>();
		type.setId(ID);
		type.setPw(PW);

		assertThat(type.getId(), is(ID));
		assertThat(type.getPw(), is(PW));
	}

	@Test
	public void 엘리먼트테스트() {
		Element<String> element = new Element<String>();
		element.setId(ID);
		element.setPw(PW);

		assertThat(element.getId(), is(ID));
		assertThat(element.getPw(), is(PW));
	}

	@Test
	public void 리스트타입전달() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");

		Type<List<String>> type = new Type<List<String>>();
		type.setId(list);
		type.setPw(PW);

		Element<List<String>> element = new Element<List<String>>();
		element.setId(list);
		element.setPw(PW);

		assertThat(type.getId().size(), is(2));
	}

	@Test
	public void VO타입전달() {
		DataVO tvo = new DataVO();
		tvo.setTest("1");
		tvo.setTest1("2");

		Type<DataVO> genericVOTest2 = new Type<DataVO>();
		genericVOTest2.setId(tvo);
		genericVOTest2.setPw("1212");
	}
}
