package json;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : UserTest.java
 * @Project : test_project
 * @Date : 2013. 7. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class JacksonTest {

	private User user;
	private String jsonListTestFilePath;
	private String jsonMapTestFilePath;
	private String jsonFactoryTestFilePath;
	private Map<String, Object> userInMap;

	/**
	 * <pre>
	 * init
	 *
	 * <pre>
	 */
	@Before
	public void init() {
		jsonListTestFilePath = "E:\\test\\json\\listTest.json";
		jsonMapTestFilePath = "E:\\test\\json\\mapTest.json";
		jsonFactoryTestFilePath = "E:\\test\\json\\factoryTest.json";

		user = new User();
		user.setAge(32);
		user.setName("kyu");

		List<String> messages = new ArrayList<String>();
		messages.add("message1");
		messages.add("message2");
		messages.add("message3");
		user.setMessages(messages);

		userInMap = new HashMap<String, Object>();
		userInMap.put("name", "namkyu");
		userInMap.put("age", 32);
		userInMap.put("messages", messages);
	}

	/**
	 * <pre>
	 * VO객체를JSON포멧으로파일에저장
	 *
	 * <pre>
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void VO객체를JSON포멧으로파일에저장() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(jsonListTestFilePath), user);
		System.out.println(mapper.writeValueAsString(user));
	}

	/**
	 * <pre>
	 * VO객체를JSON스트링으로변환
	 *
	 * <pre>
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void VO객체를JSON스트링으로변환() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(user);
		assertThat(user, is(notNullValue()));

		User user = mapper.readValue(jsonData, User.class);
		assertThat("kyu", is(user.getName()));
		assertThat(32, is(user.getAge()));
	}

	/**
	 * <pre>
	 * JSON포멧의파일을VO객체로변환
	 *
	 * <pre>
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void JSON포멧의파일을VO객체로변환() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(new File(jsonListTestFilePath), User.class);

		assertThat(32, is(user.getAge()));
		assertThat("kyu", is(user.getName()));
	}

	/**
	 * <pre>
	 * 맵객체를JSON포멧으로파일에저장
	 *
	 * <pre>
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void 맵객체를JSON포멧으로파일에저장() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(jsonMapTestFilePath), userInMap);
		System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(userInMap));
	}

	/**
	 * <pre>
	 * JSON포멧의파일을맵객체로변환
	 *
	 * <pre>
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void JSON포멧의파일을맵객체로변환() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> userInMap = mapper.readValue(new File(jsonMapTestFilePath), new TypeReference<Map<String, Object>>() {});

		assertThat(32, is(userInMap.get("age")));
		assertThat("namkyu", is(userInMap.get("name")));

		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) userInMap.get("messages");
		assertThat("message1", is(messages.get(0)));
	}

	/**
	 * <pre>
	 * JSON포멧데이터이쁘게로그찍기
	 *
	 * <pre>
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void JSON포멧데이터이쁘게로그찍기() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(user));
	}

	/**
	 * <pre>
	 * JSON포멧의파일을Tree형태로데이터추출
	 *
	 * <pre>
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@Test
	public void JSON포멧의파일을Tree형태로데이터추출() throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = new BufferedReader(new FileReader(jsonListTestFilePath));
		JsonNode rootNode = mapper.readTree(br);

		assertThat("kyu", is(rootNode.path("name").getTextValue()));
		assertThat(32, is(rootNode.path("age").getIntValue()));

		JsonNode msgNode = rootNode.path("messages");
		Iterator<JsonNode> ite = msgNode.getElements();
		while (ite.hasNext()) {
			JsonNode node = ite.next();
			System.out.println(node.getTextValue());
		}
	}

	/**
	 * <pre>
	 * 스트리밍방식을이용한JSON데이터생성
	 *
	 * <pre>
	 * @throws IOException
	 */
	@Test
	public void 스트리밍방식을이용한JSON데이터생성() throws IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonGenerator jg = jsonFactory.createJsonGenerator(new File(jsonFactoryTestFilePath), JsonEncoding.UTF8);
		jg.writeStartObject();
		jg.writeStringField("name", "tom");
		jg.writeNumberField("age", 22);
		jg.writeFieldName("messages");
		jg.writeStartArray();
		jg.writeString("message1");
		jg.writeString("message2");
		jg.writeString("message3");
		jg.writeEndArray();
		jg.writeEndObject();
		jg.close();
	}

	/**
	 * <pre>
	 * 스트리밍방식을이용한JSON데이터read
	 *
	 * <pre>
	 * @throws JsonParseException
	 * @throws IOException
	 */
	@Test
	public void 스트리밍방식을이용한JSON데이터read() throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jsonParser = jsonFactory.createJsonParser(new File(jsonFactoryTestFilePath));

		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = jsonParser.getCurrentName();
			if ("name".equals(fieldName)) {
				// currnet token is "name"
				// move to next. which is "name"s value
				jsonParser.nextToken();
				assertThat("tom", is(jsonParser.getText()));
			} else if ("messages".equals(fieldName)) {
				jsonParser.nextToken(); // currnet token is "[" move next
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					System.out.println(jsonParser.getText());
				}
			}
		}
	}
}
