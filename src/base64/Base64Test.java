package base64;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;



/**
 * @FileName : Base64Test.java
 * @Project : test_project
 * @Date : 2013. 8. 28.
 * @작성자 : nklee
 * @프로그램설명 :
 */
//@SuppressWarnings("restriction")
public class Base64Test {

	@Test
	public void base64복호화() throws UnsupportedEncodingException {
		String test = "암호화value";
		byte[] encode = Base64.encodeBase64(test.getBytes());

		String decodeValue = new String(Base64.decodeBase64(encode), "utf-8");
		assertThat(test, is(decodeValue));
	}
}
