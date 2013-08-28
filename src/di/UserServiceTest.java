package di;


/**
 * @FileName : UserServiceTest.java
 * @Project : test_project
 * @Date : 2013. 1. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserServiceTest {

	public static void main(String[] args) {

//		UserController controller = new UserController();
//		controller.setUserService(new UserServlceImpl());
//		controller.registUser();

		// 회원 저장 count 로직이 추가되야 할 때 DI전략을 이용한 프록시 패턴 사용
		UserServiceAddCnt userServiceAddCnt = new UserServiceAddCnt(); // 프록시
		userServiceAddCnt.setUserService(new UserServlceImpl()); // 타겟

		UserController controller = new UserController();
		controller.setUserService(userServiceAddCnt);

		controller.registUser();
	}

}
