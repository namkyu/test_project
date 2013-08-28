package ocp;

/**
 * @FileName : Computer.java
 * @Project : test_project
 * @Date : 2013. 2. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Computer {

	private Keyboard keyboard;

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public void boot() {
		System.out.println("부팅 중~~");
		keyboard.connect();
	}
}
