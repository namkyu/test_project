package redis.shard;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.exceptions.JedisException;


/**
 * @author <A HREF="mailto:smufu@naver.com">kris jeong</A> smufu@naver.com
 *
 * class desc
 */
public class ShardingTest2 {

	static ShardedJedisHelper helper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		helper = ShardedJedisHelper.getInstance();
	}

	@Test
	public void testSharding() {

		while(true) {
			Scanner scanner = new Scanner(System.in);
			int loopCnt = scanner.nextInt();

			ShardedJedis jedis = helper.getConnection();
			for (int i = 0; i < loopCnt; i++) {
				String testValue = "Test Value " + i;
				ShardTestKeyMaker keyMaker = new ShardTestKeyMaker(i);
				try {
					jedis.set(keyMaker.getKey(), testValue);
					System.out.println("success : " + keyMaker.getKey());
				} catch (JedisException jce) {
					System.out.println("fail : " + testValue);
					helper.returnBrokenResource(jedis);
				}
			}

			System.out.println("Done!! loopCnt : " + loopCnt);
		}
	}
}
