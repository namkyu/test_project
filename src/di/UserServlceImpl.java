package di;

/**
 * @FileName : UserServlceImpl.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserServlceImpl implements UserService {

	/**
	 * <pre>
	 * add
	 *
	 * <pre>
	 * @param user
	 */
	@Override
	public void add(User user) {
		System.out.println("회원 정보 저장");
	}

}
