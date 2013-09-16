package guava;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * @FileName : GuavaCollectionTest.java
 * @Project : test_project
 * @Date : 2013. 9. 16.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GuavaCollectionTest {

	// before and after use quava
	List<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> guavaMaps = Lists.newArrayList();

	@SuppressWarnings("unused")
	private static final Set<Locale> BEFORE_LOCALES =
			Collections.unmodifiableSet(
					new LinkedHashSet<Locale>(
							Arrays.asList(Locale.FRANCE, Locale.JAPAN, Locale.GERMAN)
					)
			);

	@SuppressWarnings("unused")
	private static final Set<Locale> AFTER_LOCALES = ImmutableSet.of(Locale.FRANCE, Locale.JAPAN, Locale.GERMAN);


	@Test
	public void staticFactories() {
		List<String> names = Lists.newArrayList("kyu", "kyoung", "jun");
		assertThat(3, is(names.size()));
	}
}
