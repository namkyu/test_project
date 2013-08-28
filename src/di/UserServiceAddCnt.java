package di;

/**
 * @FileName : UserServiceAddCnt.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserServiceAddCnt implements UserService {

	private UserService userService;

	private int userAddcnt;

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * <pre>
	 * add
	 *
	 * <pre>
	 * @param user
	 */
	@Override
	public void add(User user) {
		++userAddcnt;
		userService.add(user);

		System.out.println(userAddcnt);
	}

}
