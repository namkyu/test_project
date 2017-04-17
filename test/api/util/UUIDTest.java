package api.util;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

/**
 * @FileName : UUIDTest.java
 * @Project : test_project
 * @Date : 2012. 11. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UUIDTest {

    @Test
    public void randomTest() {
        UUID uuid = UUID.randomUUID();
        String s = Long.toString(uuid.getMostSignificantBits(), 36) + '-' + Long.toString(uuid.getLeastSignificantBits(), 36);
        System.out.println(s);
    }

    @Test
    public void test() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        String idString = Long.toString(uuid.getMostSignificantBits(), 36).replaceAll("-", "").replaceAll("[a-z]", "");
        System.out.println(idString);
    }
}
