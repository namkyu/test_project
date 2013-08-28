import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @FileName : ReflectionTest.java
 * @Project : test_project
 * @Date : 2012. 10. 15.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ReflectionTest {

	@Test
	public void testReflect() throws Exception {
		String name = "namkyu";
		assertThat(name.length(), is(6));

		Method lengthMethod = String.class.getMethod("length");
		assertThat((Integer)lengthMethod.invoke(name), is(6));
	}
}
