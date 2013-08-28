package template;

/**
 * @FileName : KeyboardTest.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class KeyboardTest {

	public static void main(String[] args) {
		AbstractKeyboardTemplate template = new SKeyboard();
		template.templateMethod();
	}
}
