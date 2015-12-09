package jsch;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

/**
 * @FileName : MyUserInfo.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public abstract class MyUserInfo implements UserInfo, UIKeyboardInteractive {

	public String getPassword() {
		return null;
	}

	public boolean promptYesNo(String str) {
		return false;
	}

	public String getPassphrase() {
		return null;
	}

	public boolean promptPassphrase(String message) {
		return false;
	}

	public boolean promptPassword(String message) {
		return false;
	}

	public void showMessage(String message) {
	}

	public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt, boolean[] echo) {
		return null;
	}
}