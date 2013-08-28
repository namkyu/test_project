package anno.controll;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	public static void main(String[] args) throws Exception {
		Map<String, String> request = makeRequest();
		String uri = request.get("uri");

		BaseController baseController = new ControllerA();
		baseController.init();
		baseController.execute(makeRequest());
		baseController.clear();
	}

	public static Map<String, String> makeRequest() {
		Map<String, String> request = new HashMap<String, String>();
		request.put("uri", "/aaa.do");
		request.put("cmd", "logout");
		request.put("userId", "namkyu");
		request.put("password", "1111");
		return request;
	}
}
