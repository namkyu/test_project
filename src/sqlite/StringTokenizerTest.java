package sqlite;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * @FileName : StringTokenizerTEst.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class StringTokenizerTest {

	@Test
	public void multipleSplietTest() {
		String msg = "http://111.222.333.444,8080";
		StringTokenizer st = new StringTokenizer(msg, ".,:/");

		assertThat("http", is(st.nextToken()));
		assertThat("111", is(st.nextToken()));
		assertThat("222", is(st.nextToken()));
		assertThat("333", is(st.nextToken()));
		assertThat("444", is(st.nextToken()));
		assertThat("8080", is(st.nextToken()));
	}

	@Test
	public void mobilePhoneTest() {
		String msg = "namkyu,010-1234-2345";
		StringTokenizer st = new StringTokenizer(msg, ",-");

		assertThat("namkyu", is(st.nextToken()));
		assertThat("010", is(st.nextToken()));
		assertThat("1234", is(st.nextToken()));
		assertThat("2345", is(st.nextToken()));
	}
}
