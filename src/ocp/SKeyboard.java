package ocp;

/**
 * @FileName : SamsungKeyboard.java
 * @Project : test_project
 * @Date : 2013. 2. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SKeyboard implements Keyboard {

	@Override
	public void connect() {
		System.out.println("S사 키보드가 연결 되었습니다.");
	}

}
