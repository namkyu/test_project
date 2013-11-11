package anno;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * @FileName : NullAnnotation.java
 * @Project : test_project
 * @Date : 2013. 11. 5.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class NullAnnotation {

	@NotNull
	private String name;

	@Nullable
	private String middleName;

	@Before
	public void before() {
		name = "kyu";
	}

	@Test
	public void nullTest() {
		assertThat("kyu", is(name));
		assertThat(middleName, nullValue());
	}
}
