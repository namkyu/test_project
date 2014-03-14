package json.jackson;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @FileName : UserInfo.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Data
public class UserInfo {

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("user_password")
	private String userPassword;

//	@JsonProperty("user_email")
//	private String userEmail;
}
