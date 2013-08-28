package json;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : User.java
 * @Project : test_project
 * @Date : 2013. 7. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class User {

	private int age;
	private String name;
	private List<String> messages = new ArrayList<String>();
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
