package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @FileName : UserNameValidator.java
 * @Project : test_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserNameValidator {

	private final Pattern pattern;
	private Matcher matcher;
	private static final String USER_NAME_PATTERN = "^[a-z0-9_-]{3,15}$";

	/**
	 * constructor
	 */
	public UserNameValidator() {
		pattern = Pattern.compile(USER_NAME_PATTERN);
	}

	/**
	 * <pre>
	 * valid
	 * user name check
	 * <pre>
	 * @param userName
	 * @return
	 */
	public boolean valid(String userName) {
		matcher = pattern.matcher(userName);
		boolean isMatched = matcher.matches();
		return isMatched;
	}
}
