package packagetest.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class HelloWorldJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Hello World!");

		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString("kyuTest");
		System.out.println(jsonData);
	}
}
