package template;

/**
 * @FileName : SKeyboard.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SKeyboard extends AbstractKeyboardTemplate {

	/**
	 * <pre>
	 * getConnect
	 *
	 * <pre>
	 * @return
	 */
	@Override
	protected String getConnectDriver() {
		return "삼성키보드연결 드라이버";
	}

}
