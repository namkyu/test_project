package generic;

import lombok.Data;

/**
 * @FileName : Element.java
 * @Project : test_project
 * @Date : 2012. 10. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@Data
public class Element<E> {

	private E id;
	private String pw;

}
