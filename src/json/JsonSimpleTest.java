package json;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * @FileName : JsonSimpleTest.java
 * @Project : test_project
 * @Date : 2013. 7. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class JsonSimpleTest {


	@Test
	@SuppressWarnings("unchecked")
	public void simpleTest1() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "namkyu");
		jsonObject.put("age", 32);

		List<String> list = new ArrayList<String>();
		list.add("message1");
		list.add("message2");
		list.add("message3");
		jsonObject.put("messages", list);

		String jsonData = jsonObject.toJSONString();
		List<String> msgList = (List<String>) jsonObject.get("messages");

		// test
		assertThat(jsonData, is(notNullValue()));
		assertThat("namkyu", is(jsonObject.get("name")));
		assertThat(32, is(jsonObject.get("age")));
		assertThat("message1", is(msgList.get(0)));
		assertThat("message2", is(msgList.get(1)));
		assertThat("message3", is(msgList.get(2)));
	}
}
