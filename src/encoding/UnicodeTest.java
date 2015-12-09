package encoding;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

/**
 * @FileName : UnicodeTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class UnicodeTest {

	@Test
	public void unicodeToAlphabet() {
		String str = "\u0041 \u0042 \u004F";
		System.out.println(str);

		String diff1 = "\u0041";
		String diff2 = "A";
		char diff3 = 'A';

		System.out.println(diff1.equals(diff2));
		System.out.println(diff1.equals(diff3));
	}

	@Test
	public void 메세지프로퍼티정보() {
		String str = "\uba54\uc138\uc9c0 \ud504\ub85c\ud37c\ud2f0 test";
		System.out.println(str);
	}

	@Test
	public void 특수기호() {
		String str = "\u1070 \u1071 \u1072 \u1073";
		System.out.println(str);
	}

	@Test
	public void 한글테스트() {
		String str = "\u1100 \u1101 \u1102 \uba54";
		System.out.println(str);

		String str1 = "\uba54\uc138\uc9c0 \ud504\ub85c\ud37c\ud2f0 test";
		System.out.println(str1);
	}

	@Test
	public void to인코딩변환() throws Exception {
		String alpha = "a";
		String hangle = "\uAC00";

		System.out.println("알파벳 : " + alpha);
		System.out.println("한글 : " + hangle);
		System.out.println();

		byte[] alphaBts = alpha.getBytes("UTF-8");
		byte[] hangleBts = hangle.getBytes("UTF-8");
		System.out.println("====================================");
		System.out.println("UTF-8");
		System.out.println("====================================");
		System.out.println("알파 : " + Arrays.toString(alphaBts));
		System.out.println("한글 : " + Arrays.toString(hangleBts));
		System.out.println();

		alphaBts = alpha.getBytes("UTF-16");
		hangleBts = hangle.getBytes("UTF-16");
		System.out.println("====================================");
		System.out.println("UTF-16");
		System.out.println("====================================");
		System.out.println("알파 : " + Arrays.toString(alphaBts));
		System.out.println("한글 : " + Arrays.toString(hangleBts));
		System.out.println();

		alphaBts = alpha.getBytes("UTF-16BE");
		hangleBts = hangle.getBytes("UTF-16BE");
		System.out.println("====================================");
		System.out.println("UTF-16BE");
		System.out.println("====================================");
		System.out.println("알파 : " + Arrays.toString(alphaBts));
		System.out.println("한글 : " + Arrays.toString(hangleBts));
		System.out.println();

		alphaBts = alpha.getBytes("UTF-16LE");
		hangleBts = hangle.getBytes("UTF-16LE");
		System.out.println("====================================");
		System.out.println("UTF-16LE");
		System.out.println("====================================");
		System.out.println("알파 : " + Arrays.toString(alphaBts));
		System.out.println("한글 : " + Arrays.toString(hangleBts));
		System.out.println();

		alphaBts = alpha.getBytes("UTF-32");
		hangleBts = hangle.getBytes("UTF-32");
		System.out.println("====================================");
		System.out.println("UTF-32");
		System.out.println("====================================");
		System.out.println("알파 : " + Arrays.toString(alphaBts));
		System.out.println("한글 : " + Arrays.toString(hangleBts));
		System.out.println();
	}

	@Test
	public void intToByte() {
		byte[] data = new byte[3];
		int idx = 0;
		int value = 15380608;

		data[idx] = (byte) (value >> 16);
		data[++idx] = (byte) (value >> 8);
		data[++idx] = (byte) value;

		System.out.println(Arrays.toString(data));
	}

	@Test
	public void test() throws UnsupportedEncodingException {
		String test = "\uC790";
		System.out.println(test);

		byte[] bt = test.getBytes("UTF-8");
		for (byte b : bt) {
			System.out.println(Integer.toBinaryString(b));
		}
	}
}
