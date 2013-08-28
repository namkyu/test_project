package anno.controll;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public abstract class BaseController {

	public Object execute(Map<String, String> request) throws Exception {
		Object obj = null;

		// 어떤 메소드를 실행하는가에 대한 정보를 알아내야 한다.
		Action actionAnno = this.getClass().getAnnotation(Action.class);
		String cri = actionAnno.criterion();

		// aaa.do?cmd=login
		String methodName = request.get(cri);
		Method[] methods = this.getClass().getMethods();
		Method targetMethod = null;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				targetMethod = method;
				break;
			}
		}

		// Request의 파라미터와 메소드의 파라미터 비교
		Object[] params = null;
		Annotation[][] paramAnno = targetMethod.getParameterAnnotations();
		params = new Object[paramAnno.length];
		int idx = 0;

		for (Annotation[] tempArr : paramAnno) {
			RequestParam requestParam = (RequestParam) tempArr[0];
			String paramValue = request.get(requestParam.value());
			params[idx++] = paramValue;
		}

		// 세팅 실행, 결과
		System.out.println(Arrays.toString(params));
		obj = targetMethod.invoke(this, params);

		return obj;
	}

	public void init() throws Exception {
		System.out.println("init......");
	}

	public void clear() throws Exception {
		System.out.println("clear.......");
	}
}
