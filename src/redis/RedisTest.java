package redis;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @FileName : RedisTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class RedisTest {

	private String REDIS_ADDRESS = "lnk1982.cafe24.com";
	private Jedis jedis;

	@Before
	public void init() {
		jedis = new Jedis(REDIS_ADDRESS);
	}

	@Test
	public void test1() {
		System.out.println("Server is running : " + jedis.ping());
	}

	@Test
	public void test2() {
		jedis.set("hello", "hello world!!");
		String value = jedis.get("hello");
		assertThat("hello world!!", is(value));
	}

	@Test
	public void listTest() {
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis : " + list.get(i));
		}
	}

	@Test
	public void allKeys() {
		Set<String> set = jedis.keys("*");
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println("List of stored keys : " + iterator.next());
		}

	}

}
