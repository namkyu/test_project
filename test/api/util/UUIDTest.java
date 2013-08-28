package api.util;

import java.util.UUID;

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
		System.out.println(uuid.toString());
		System.out.println(uuid.version());
	}
}
