import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @FileName : LombokTest.java
 * @Project : test_project
 * @Date : 2012. 10. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LombokTest {

	@Test
	public void lombok테스트() {

		Lombok lombok = new Lombok();
		lombok.setAge(31);
		lombok.setName("namkyu");

		assertThat(lombok.getAge(), is(notNullValue()));
		assertThat(lombok.getName(), is(notNullValue()));
	}
}
