package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

/**
 * @FileName : MQTT.java
 * @Project : test_project
 * @Date : 2016. 10. 26.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class MQTT {

	@Test
	public void test() {
		try {
			MqttClient client = new MqttClient("tcp://localhost:1883", "clientID");
			client.connect();
			MqttMessage message = new MqttMessage();
			message.setPayload("send my message!!".getBytes());
			client.publish("test1", message);
			client.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
