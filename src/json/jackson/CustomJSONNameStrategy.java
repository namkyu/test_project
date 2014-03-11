package json.jackson;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

/**
 * @FileName : CustomJSONNameStrategy.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class CustomJSONNameStrategy extends PropertyNamingStrategy {

	/**
	 * <pre>
	 * nameForField
	 *
	 * <pre>
	 * @param config
	 * @param field
	 * @param defaultName
	 * @return
	 */
	@Override
	public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
		return convert(defaultName);
	}

	/**
	 * <pre>
	 * nameForGetterMethod
	 *
	 * <pre>
	 * @param config
	 * @param method
	 * @param defaultName
	 * @return
	 */
	@Override
	public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
		return convert(defaultName);
	}

	/**
	 * <pre>
	 * nameForSetterMethod
	 *
	 * <pre>
	 * @param config
	 * @param method
	 * @param defaultName
	 * @return
	 */
	@Override
	public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
		return convert(defaultName);
	}

	/**
	 * <pre>
	 * convert
	 *
	 * <pre>
	 * @param defaultName
	 * @return
	 */
	public String convert(String defaultName) {
		char[] arr = defaultName.toCharArray();
		if (arr.length != 0) {
			if (Character.isLowerCase(arr[0])) {
				char upper = Character.toUpperCase(arr[0]);
				arr[0] = upper;
			}
		}
		return new StringBuilder().append(arr).toString();
	}
}
