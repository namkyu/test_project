import java.text.DecimalFormat;


/**
 * @FileName : DecimalFormatTest.java
 * @Project : test_project
 * @Date : 2012. 7. 10.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DecimalFormatTest {

	public static void main(String[] args) {
		int code = 123;
		DecimalFormat decimalFormat = new DecimalFormat("00000");
		String result = decimalFormat.format(code);
		System.out.println(result);
	}
}
