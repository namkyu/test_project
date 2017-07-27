package pg;


import org.json.simple.JSONObject;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Project : test_project
 * @Date : 2017-07-27
 * @Author : nklee
 * @Description :
 */
public class TossTest {

    @Test
    public void 토스결제생성() {

        URL url = null;
        URLConnection connection = null;
        StringBuilder responseBody = new StringBuilder();
        try {
            url = new URL("https://toss.im/tosspay/api/v1/payments");
            connection = url.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 전송 파라미터
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderNo", "2015072012211");
            jsonBody.put("amount", 10000);
            jsonBody.put("productDesc", "신비의물약");
            jsonBody.put("apiKey", "sk_test_apikey1234567890a");
            jsonBody.put("autoExecute", false);
            jsonBody.put("retUrl", "http://test.com/ORDER-CHECK");

            // 요청
            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            bos.write(jsonBody.toJSONString().getBytes());
            bos.flush();
            bos.close();

            // 응답
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                responseBody.append(line);
            }
            br.close();
        } catch (Exception e) {
            responseBody.append(e);
        }

        System.out.println(responseBody.toString());
    }
}
