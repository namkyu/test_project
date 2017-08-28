package access.defaultaccess;

/**
 * @Project : test_project
 * @Date : 2017-08-17
 * @Author : nklee
 * @Description :
 */
public class CMonitor extends AMonitor implements Monitor {

    @Override
    public void display() {
        test();
        System.out.println(super.a);
    }
}
