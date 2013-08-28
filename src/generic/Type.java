package generic;

import lombok.Data;

/**
 * @param <T>
 * @FileName : GenericVOTest.java
 * @Project : test_project
 * @Date : 2012. 10. 12.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@Data
public class Type<T> {

	private T id;
	private String pw;

}
