package generic;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : GenericMethodTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GenericMethodTest {

	private Map<String, Object> contextObjMap;

	@Before
	public void setup() {
		 contextObjMap = new HashMap<String, Object>();
		 contextObjMap.put("objA", new ObjA());
		 contextObjMap.put("objB", new ObjB());
		 contextObjMap.put("objC", new ObjC());
	}

	// ---------------------- 첫 번째 방법 ---------------------------------

	public ObjB getObj(String objKey) {
		return (ObjB) contextObjMap.get(objKey);
	}

	@Test
	public void test() {
		// objB 추출
		assertThat(getObj("objB"), is(instanceOf(ObjB.class)));
	}

	// ---------------------- 두 번째 방법 ---------------------------------

	@SuppressWarnings("unchecked")
	public <T> T getObj(String objKey, Class<T> type) {
		return (T) contextObjMap.get(objKey);
	}

	@Test
	public void genericMethodTest() {
		// objA 추출
		assertThat(getObj("objA", ObjA.class), is(instanceOf(ObjA.class)));
		// objB 추출
		assertThat(getObj("objB", ObjB.class), is(instanceOf(ObjB.class)));
		// objC 추출
		assertThat(getObj("objC", ObjC.class), is(instanceOf(ObjC.class)));
	}
}

class ObjA {

}

class ObjB {

}

class ObjC {

}