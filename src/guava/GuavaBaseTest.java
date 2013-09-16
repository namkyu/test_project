package guava;

import static com.google.common.base.Preconditions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;

/**
 * @FileName : StrinsTest.java
 * @Project : test_project
 * @Date : 2013. 9. 16.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GuavaBaseTest {

	@Test
	public void toStringTest() {
		Employee employee = new Employee();
		employee.setName("kyu");
		employee.setAge(32);

		Employee other = new Employee();
		other.setName("kyu");
		other.setAge(33);

		assertThat(-1, is(employee.compareTo(other)));
	}

	/**
	 * <pre>
	 * firstNonNullTest
	 * 삼항연산자 대신 사용하자.
	 * <pre>
	 */
	@Test
	public void firstNonNullTest() {
		assertThat("changeValue", is(Objects.firstNonNull(null, "changeValue")));
	}

	/**
	 * <pre>
	 * joinerTest
	 * Collection 객체의 String 변환 시 이용
	 * <pre>
	 */
	@Test
	public void joinerTest() {
		List<String> computerBrands = Lists.newArrayList("hp", "samsung", "LG");
		String names = Joiner.on(",").join(computerBrands);
		assertThat("hp,samsung,LG", is(names));

		List<String> mobilePhoneBrands = Lists.newArrayList("iphone", "samsung", null, "LG");
		String mobilePhoneNames = Joiner.on(",").skipNulls().join(mobilePhoneBrands);
		assertThat("iphone,samsung,LG", is(mobilePhoneNames));

		List<String> notebookBrands = Lists.newArrayList("iphone", "samsung", null, "LG");
		String notebookNames = Joiner.on(",").useForNull("google").join(notebookBrands);
		assertThat("iphone,samsung,google,LG", is(notebookNames));

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		String mapKeyValues = Joiner.on("\n").withKeyValueSeparator(" : ").join(map);
		assertThat("1 : a\n2 : b\n3 : c", is(mapKeyValues));
	}

	@Test
	public void splitterTest() {
		Iterable<String> iterable = null;

		iterable = Splitter.on(",").split("a, ,c,d");
		System.out.println(iterable);

		iterable = Splitter.on(",").trimResults().split("a, ,c,d");
		System.out.println(iterable);

		iterable = Splitter.on(",").trimResults().omitEmptyStrings().split("a, ,c,d");
		System.out.println(iterable);
	}

	/**
	 * <pre>
	 * preconditionsTest1
	 * 값이 null인 경우 예외 발생 시킬 때 사용하자.
	 * <pre>
	 */
	@Test(expected = NullPointerException.class)
	public void preconditionsTest1() {
		String amount = null;
		String currency = null;
		checkNotNull(amount, "amount must not be null");
		checkNotNull(currency, "currency must not be null");
	}

	/**
	 * <pre>
	 * preconditionsTest2
	 * 조건에 의한 예외 발생 시 사용하자.
	 * <pre>
	 */
	@Test(expected = IllegalArgumentException.class)
	public void preconditionsTest2() {
		int pocketMoney = 18000;
		checkArgument(pocketMoney > 100000, "I want to pocket money over 100,000won but real money : %s", pocketMoney);
	}

	@Test
	public void StringsTest() {
		assertThat("kyu", is(Strings.nullToEmpty("kyu")));
	}

	@Test
	public void javaStringTest() {
		assertThat(0, is("a".compareTo("a")));
		assertThat(-1, is("a".compareTo("b")));
		assertThat(-2, is("a".compareTo("c")));
		assertThat(-3, is("a".compareTo("d")));

		assertThat(1, is("b".compareTo("a")));
		assertThat(4, is("e".compareTo("a")));

		assertThat(0, is("가".compareTo("가")));
		assertThat(-1176, is("가".compareTo("나")));
	}

	@Test
	public void charsetsTest() {
		String name = "kyu";
		name.getBytes(Charsets.UTF_8);
	}
}

@Data
class Employee {
	private String name;
	private int age;

	public String toString() {
		return Objects.toStringHelper(this)
			.add("name", name)
			.add("age", age)
			.toString();
	}

	public int compareTo(Employee other) {
		// name, age 필드가 같은지를 검증할 때 사용하면 if문을 없앨 수 있다.
		return ComparisonChain.start()
				.compare(name, other.name)
				.compare(age, other.age)
				.result();
	}

}