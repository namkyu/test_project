package json;

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
public class TestClass {

	@JsonProperty("a")
	private int a;

	public TestClass() {

	}
}
