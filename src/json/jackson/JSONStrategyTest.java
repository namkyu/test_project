package json.jackson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @FileName : JSONStrategyTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class JSONStrategyTest {

	private static String filePath = "E:\\test\\json\\namingStrategyTest.json";

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		init();
		ObjectMapper mapper = new ObjectMapper();

		// json string value
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		System.out.println("##json## " + reader.readLine());

		// gate -> api
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.USE_ANNOTATIONS, true);
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		UserInfo user = mapper.readValue(new File(filePath), UserInfo.class);
		System.out.println("##read## " + user);

		// api -> front
		mapper.configure(org.codehaus.jackson.map.SerializationConfig.Feature.USE_ANNOTATIONS, false);
		String jsonResult = mapper.writeValueAsString(user);
		System.out.println("##write## " + jsonResult);
	}

	/**
	 * <pre>
	 * init
	 *
	 * <pre>
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 */
	private static void init() throws IOException, JsonGenerationException, JsonMappingException {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("user_id", "testUser");
		userMap.put("user_password", "1111");
		userMap.put("user_email", "nk@nc");
		new ObjectMapper().writeValue(new File(filePath), userMap);
	}
}
