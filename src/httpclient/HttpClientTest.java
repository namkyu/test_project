package httpclient;

import httpclient.vo.Row;
import httpclient.vo.WeatherVO;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

/**
 * @FileName : HttpClientTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class HttpClientTest {

	@Test
	public void testWeather() throws ClientProtocolException, IOException {
		Content content = Request.Get("http://openapi.seoul.go.kr:8088/7470784c746c6e673836727a49536b/json/ForecastWarningUltrafineParticleOfDustService/1/5/")
				.execute().returnContent();

		ObjectMapper mapper = new ObjectMapper();
		WeatherVO vo = mapper.readValue(content.toString(), WeatherVO.class);

		List<Row> row = vo.getForecastWarningUltrafineParticleOfDustService().getRow();
		for (Row weatherRowData : row) {
			String result = weatherRowData.getCAISTEP();
			System.out.println(result);
		}
	}
}
