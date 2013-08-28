package anno.controll;


@Action(value = "/aaa.do", criterion = "cmd")
public class ControllerA extends BaseController {

	public void login(@RequestParam("userId") String userId
					, @RequestParam("password") String password) throws Exception {

		System.out.println("서비스 객체를 통해서 로그인을 한다.");
		System.out.println(userId);
		System.out.println(password);
		System.out.println("로그인 작업을 끝냈음.");
	}

	public void logout(@RequestParam("userId") String userId
					 , @RequestParam("password") String password) throws Exception {

		System.out.println("서비스 객체를 통해서 로그아웃 한다.");
		System.out.println(userId);
		System.out.println(password);
		System.out.println("로그아웃 작업을 끝냈음.");
	}

}
