import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;


/**
 * @FileName : EUCKRTetst.java
 * @Project : test_project
 * @Date : 2013. 5. 22.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class EUCKRTest {


	@Test
	public void euckr테스트() throws UnsupportedEncodingException {
		String test = "하이";
		assertThat(test, is(encodeValue(test, "euc-kr", "euc-kr")));
		assertThat(test, is(encodeValue(test, "euc-kr", "ms949")));
		assertThat(test, is(encodeValue(test, "euc-kr", "ksc5601")));
		assertThat(test, is(not(encodeValue(test, "euc-kr", "utf-8"))));
		assertThat(test, is(not(encodeValue(test, "euc-kr", "iso-8859-1"))));

		assertThat(test, is(encodeValue(test, "utf-8", "utf-8")));
		assertThat(test, is(encodeValue(test, "utf-8", "utf8")));
		assertThat(test, is(not(encodeValue(test, "utf-8", "euc-kr"))));
		assertThat(test, is(not(encodeValue(test, "utf-8", "ksc5601"))));
		assertThat(test, is(not(encodeValue(test, "utf-8", "iso-8859-1"))));

		String test1 = "뷁";
		assertThat(test1, is(encodeValue(test1, "utf-8", "utf-8")));
		assertThat(test1, is(not(encodeValue(test1, "euc-kr", "euc-kr"))));
		assertThat(test1, is(not(encodeValue(test1, "euc-kr", "utf-8"))));
		assertThat(test1, is(not(encodeValue(test1, "euc-kr", "ksc5601"))));

		String test2 = "강";
		assertThat(test2, is(encodeValue(test2, "utf-8", "utf-8")));
	}

	private static String encodeValue(String str, String byteEncode, String strEncode) {
		String resultValue = null;
		try {
			resultValue = new String(str.getBytes(byteEncode), strEncode);
		} catch (UnsupportedEncodingException e) {
			new RuntimeException(e);
		}
		return resultValue;
	}
}
