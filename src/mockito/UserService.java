package mockito;

/**
 * @FileName : UserService.java
 * @Project : test_project
 * @Date : 2013. 8. 5.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserService {

	private UserManager manager;

	public UserService() {
		this(new UserManager());
	}

	public UserService(UserManager userManager) {
		this.manager = userManager;
	}

	public int getUserCount() {
		try {
			return manager.getUserCount();
		} catch (Exception ex) {
			return -1;
		}
	}
}
