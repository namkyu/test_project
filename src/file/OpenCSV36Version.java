package file;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.bean.MappingStrategy;

/**
 * @FileName : OpenCSV36Version.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class OpenCSV36Version {

	private static final String TEST_STRING = "name,orderNumber,num\n" + "kyle,abc123456,123\n" + "jimmy,def098765,456";
	private static final String TEST_STRING1 = "이름,주문번호,num\n" + "kyle,abc123456,123\n" + "jimmy,def098765,456";
	private static final String TEST_STRING_WITHOUT_HEADER = "kyle,abc123456,123\n" + "한글,def098765,456";

	@Test
	public void test2() {
		HeaderColumnNameMappingStrategy<MockBean> strategy = new HeaderColumnNameMappingStrategy<MockBean>();
		strategy.setType(MockBean.class);
		CsvToBean<MockBean> bean = new CsvToBean<MockBean>();

		StringReader reader = new StringReader(TEST_STRING);
		CSVReader csvReader = new CSVReader(reader, ',');
		List<MockBean> beanList = bean.parse(strategy, csvReader);

		System.out.println(beanList);
	}

	@Test
	public void test3() {
		CsvToBean<MockBean> csv = new CsvToBean<>();
		CSVReader csvReader = new CSVReader(new StringReader(TEST_STRING_WITHOUT_HEADER));

		List<MockBean> list = csv.parse(setColumMapping(), csvReader);
		for (MockBean mockBean : list) {
			System.out.println(mockBean);
		}
	}

	@Test
	public void test4() {
		HeaderColumnNameTranslateMappingStrategy<MockBean> strategy = new HeaderColumnNameTranslateMappingStrategy<MockBean>();

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("이름", "name");
		columnMapping.put("주문번호", "orderNumber");
		columnMapping.put("num", "numTest");

		strategy.setType(MockBean.class);
		strategy.setColumnMapping(columnMapping);

		CsvToBean<MockBean> bean = new CsvToBean<MockBean>();

		StringReader reader = new StringReader(TEST_STRING1);
		CSVReader csvReader = new CSVReader(reader, ',');
		List<MockBean> beanList = bean.parse(strategy, csvReader);

		System.out.println(beanList);
	}

	/**
	 * <pre>
	 * setColumMapping
	 *
	 * <pre>
	 * @return
	 */
	private MappingStrategy<MockBean> setColumMapping() {
		ColumnPositionMappingStrategy<MockBean> strategy = new ColumnPositionMappingStrategy<>();
		strategy.setType(MockBean.class);
		String[] columns = new String[] {"name", "orderNumber", "num"};
		strategy.setColumnMapping(columns);
		return strategy;
	}

}

