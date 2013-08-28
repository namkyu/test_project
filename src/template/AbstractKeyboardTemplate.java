package template;


/**
 * @FileName : AbstractTemplate.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public abstract class AbstractKeyboardTemplate {

	protected void templateMethod() {
		String connect = getConnectDriver();
		System.out.println(connect);

		loadDriver(connect);
	}

	/**
	 * <pre>
	 * loadDriver
	 *
	 * <pre>
	 * @param connect
	 */
	private void loadDriver(String connect) {
		System.out.println("컴퓨터에 키보드 드라이버 로드!!");
	}

	protected abstract String getConnectDriver();
}
