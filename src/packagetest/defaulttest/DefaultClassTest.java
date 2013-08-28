package packagetest.defaulttest;

import org.junit.Test;

/**
 * @FileName : DefaultClassTest.java
 * @Project : test_project
 * @Date : 2013. 6. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class DefaultClassTest {

	@Test
	public void functionCallTest() {
		DefaultClass defaultClass = new DefaultClass();
		defaultClass.defaultAccessConstraint();
	}
}
