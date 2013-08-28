import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lombok.Data;

import org.junit.Before;
import org.junit.Test;


/**
 * @FileName : CloneTest.java
 * @Project : test_project
 * @Date : 2012. 11. 5.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class CloneTest {

	private CloneVO vo1;

	@Before
	public void VO데이터생성() {
		vo1 = new CloneVO();
		vo1.setId("id");
		vo1.setName("name");
	}

	@Test
	public void 객체복사() {
		CloneVO vo2 = vo1.clone();
		vo2.setId("id2");
		vo2.setName("name2");

		assertThat(vo1.getId(), not(vo2.getId()));
		assertThat(vo1.getName(), not(vo2.getName()));
	}

	@Test
	public void 레퍼런스복사() {
		CloneVO vo2 = vo1;

		vo2.setId("id2");
		vo2.setName("name2");

		assertThat(vo1.getId(), is(vo2.getId()));
		assertThat(vo1.getName(), is(vo2.getName()));
	}


}

@Data
class CloneVO implements Cloneable {

	private String name;
	private String id;

	/**
	 * <pre>
	 * clone
	 *
	 * <pre>
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected CloneVO clone() {
		try {
			CloneVO cloneVO = (CloneVO) super.clone();
			return cloneVO;
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
