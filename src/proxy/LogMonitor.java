package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @FileName : LogMonitor.java
 * @Project : test_project
 * @Date : 2013. 2. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LogMonitor implements InvocationHandler {

	private final Monitor monitor;

	public LogMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * <pre>
	 * invoke
	 *
	 * <pre>
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = method.invoke(monitor, args);
		return "start " + ret;
	}

}
