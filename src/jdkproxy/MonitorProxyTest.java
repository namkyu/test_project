package jdkproxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @FileName : MonitorProxyTest.java
 * @Project : test_project
 * @Date : 2013. 2. 26.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MonitorProxyTest {

    @Test
    public void test() {
        Monitor monitor = new LMonitor();
        assertThat("display", is(monitor.display()));

        // JDK Dynamic Proxy 테스트
        Monitor proxyMonitor = (Monitor) Proxy.newProxyInstance(MonitorProxyTest.class.getClassLoader()
                , new Class[]{Monitor.class}
                , new LogMonitor(new LMonitor()));

        String result = proxyMonitor.display();
        assertThat("start display", is(result));
    }

}
