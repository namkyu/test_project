package proxy;

/**
 * @FileName : LMonitor.java
 * @Project : test_project
 * @Date : 2013. 2. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LMonitor implements Monitor {

	/**
	 *
	 */
	public LMonitor() {
		System.out.println(getClass());
	}

	/**
	 * <pre>
	 * display
	 *
	 * <pre>
	 */
	@Override
	public String display() {
		return "display";
	}

}
