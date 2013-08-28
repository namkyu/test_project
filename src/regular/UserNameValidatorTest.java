package regular;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @FileName : UserNameValidatorTest.java
 * @Project : test_project
 * @Date : 2012. 7. 9.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserNameValidatorTest {

	private static UserNameValidator userNameValidator;

	@BeforeClass
	public static void initDate() {
		userNameValidator = new UserNameValidator();
	}

	@AfterClass
	public static void endTest() {
		System.out.println("UNIT TEST END!!");
	}

	public List<String> validUsernameProvider() {
		List<String> userNameList = new ArrayList<String>();
		userNameList.add("lng1982");
		userNameList.add("lng_1982");
		userNameList.add("lng-1982");
		userNameList.add("ln-g_1982");
		return userNameList;
	}

	public List<String> invalidUserNameProvider() {
		List<String> userNameList = new ArrayList<String>();
		userNameList.add("ln");
		userNameList.add("lng@1982");
		userNameList.add("lng19821231231313_-");
		return userNameList;
	}

	@After
	public void afterProcess() {
		// Test 완료 후 호출 된다.
	}

	@Test
	public void validUserNameTest() {
		List<String> userNameList = validUsernameProvider();
		for (String userName : userNameList) {
			boolean valid = userNameValidator.valid(userName);
			Assert.assertEquals(true, valid);
		}
	}

	@Test
	public void invalidUserNameTest() {
		List<String> userNameList = invalidUserNameProvider();
		for (String userName : userNameList) {
			boolean valid = userNameValidator.valid(userName);
			Assert.assertEquals(false, valid);
		}
	}
}
