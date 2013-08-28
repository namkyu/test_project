package ocp;

/**
 * @FileName : Client.java
 * @Project : test_project
 * @Date : 2013. 2. 25.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class BootStrap {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.setKeyboard(new SKeyboard());
		computer.boot();
	}
}
