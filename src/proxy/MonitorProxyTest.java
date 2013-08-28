package proxy;

import java.lang.reflect.Proxy;

/**
 * @FileName : MonitorProxyTest.java
 * @Project : test_project
 * @Date : 2013. 2. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MonitorProxyTest {

	public static void main(String[] args) {

		Monitor proxyMonitor = (Monitor) Proxy.newProxyInstance(MonitorProxyTest.class.getClassLoader()
															, new Class[] { Monitor.class }
															, new LogMonitor(new LMonitor()));

		String result = proxyMonitor.display();
		System.out.println(result);

		LMonitor monitor = new ChildMonitor();
	}

}
