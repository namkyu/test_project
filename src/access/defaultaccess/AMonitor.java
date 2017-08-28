package access.defaultaccess;

/**
 * @Project : test_project
 * @Date : 2017-08-17
 * @Author : nklee
 * @Description :
 */
public class AMonitor implements Monitor {

    int a = 10;

    @Override
    public void display() {

    }

    void test() {
        System.out.println("test method called!!!");
    }
}
