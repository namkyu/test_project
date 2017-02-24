package json;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @FileName : User.java
 * @Project : test_project
 * @Date : 2013. 7. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@Data
public class User {

	@JsonProperty("age_test")
	private int age;

	@JsonProperty("name_test")
	private String name;

	@JsonProperty("messages_test")
	private List<String> messages = new ArrayList<String>();

	@JsonProperty("testClass")
	private TestClass testClass;
}
