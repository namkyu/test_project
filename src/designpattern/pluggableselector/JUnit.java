package designpattern.pluggableselector;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : test_project
 * @Date : 2017-07-11
 * @Author : nklee
 * @Description :
 */
public class JUnit {

    Map<String, Class> map = new HashMap();

    public void addTest(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);

            if (method.getName().startsWith("test")) {
                map.put(method.getName(), clazz);
            }
        }
    }

    public void runTest() throws Exception {
        for (String testName : map.keySet()) {
            Class clazz = map.get(testName);

            Method setUp = clazz.getDeclaredMethod("setUp");
            Method tearDown = clazz.getDeclaredMethod("tearDown");
            Method testMethod = clazz.getDeclaredMethod(testName);

            Object testObject = clazz.newInstance();
            setUp.invoke(testObject);
            testMethod.invoke(testObject);
            tearDown.invoke(testObject);

        }
    }

    public static void main(String[] args) throws Exception {
        JUnit junit = new JUnit();
        junit.addTest(UnderTest.class);
        junit.runTest();
    }


}

class UnderTest {

    public void setUp() {
        System.out.println("setUp()");
    }

    public void testCase1() {
        System.out.println("testCase1()");
    }

    public void testCase2() {
        System.out.println("testCase2()");
    }

    public void tearDown() {
        System.out.println("tearDown()");
    }
}