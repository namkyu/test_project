import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @FileName : CallByValueTest.java
 * @Project : test_project
 * @Date : 2012. 11. 7.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class CallByValueTest {


    /**
     * <pre>
     * 원시변수테스트
     * 원시변수를 메서드의 인자값으로 전달하면 복사된 값이 메서드의 스택에 저장하고, 호출된 메서드는 복사된 값을 이용한다.
     * <pre>
     */
    @Test
    public void 원시변수테스트() {
        String str = "namkyu";
        changeObject(str);
        assertThat(str, is(str)); // call by value (namkyu == namkyu)

        int cnt = 1;
        changeObject(cnt);
        assertThat(cnt, is(cnt)); // call by value (1 == 1)

        String[] strArr = {"1", "2"};
        chageArr(strArr);
        assertThat("3", is(strArr[1])); // call by value
    }

    public static void chageArr(String[] strArr) {
        strArr[1] = "3";
    }

    /**
     * <pre>
     * List객체테스트
     *
     * <pre>
     */
    @Test
    public void List객체테스트() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        changeObject(list);
        assertThat(list, is(notNullValue())); // call by value
    }

    /**
     * <pre>
     * VO객체테스트
     *
     * <pre>
     */
    @Test
    public void VO객체테스트() {
        TestVO vo = new TestVO();
        vo.setName("kyu");

        changeObject(vo);
        assertThat(vo, is(notNullValue())); // call by value

        String name = vo.getName();
        changeVO(vo);
        assertThat(name, is(not(vo.getName()))); // call by value
    }

    public <T> void changeObject(T obj) {
        obj = null;
    }

    public void changeVO(TestVO vo) { // TestVO의 레퍼런스 변수의 값을 복사해서 넘겨준다.
        vo.setName("namkyu");
        vo = null; // 레퍼런스 변수 null 처리 (heap 영역의 인스턴스와 연결 고리가 끊어짐)
    }

    class TestVO {

        private String name;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
    }
}