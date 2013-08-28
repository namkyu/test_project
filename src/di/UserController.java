package di;

/**
 * @FileName : UserController.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserController {

	private UserService userService;

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void registUser() {
		userService.add(getUserData());
	}

	private User getUserData() {
		User user = new User();
		user.setAge(31);
		user.setName("남규");
		return user;
	}

}
