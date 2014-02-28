package matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @FileName : HamcrestMatcherTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class HamcrestMatcherTest {

	private static final String test = "kyu";

	@Test
	@SuppressWarnings("unchecked")
	public void allOfTest() {
		assertThat(test, is(allOf(notNullValue(), equalTo(test))));
		assertThat(test, is(allOf(notNullValue(), instanceOf(String.class), equalTo(test))));
	}

	@Test
	public void anyTest() {
		assertThat(test, is(any(String.class)));
		assertThat(test, is(any(Object.class)));
	}

	@Test
	public void isTest() {
		assertThat(test, is(test));
		assertThat(test, equalTo(test));

		assertThat(test, is(String.class));
		assertThat(test, instanceOf(String.class));
		assertThat(test, is(sameInstance(test)));
	}

	@Test
	public void notTest() {
		assertThat(test, is(not("kyu2")));
		assertThat(test, is(not(nullValue())));
	}

}
