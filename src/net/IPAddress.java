package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @FileName : IPAddress.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class IPAddress {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress myIp = InetAddress.getLocalHost();
		String ipAddress = myIp.getHostAddress();
		String hostName = myIp.getHostName();

		System.out.printf("IP address of localhost is %s %n", ipAddress);
		System.out.printf("Host name of your machine is %s %n", hostName);
	}
}
