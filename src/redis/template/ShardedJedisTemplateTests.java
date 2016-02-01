package redis.template;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.template.core.ShardedJedisClient;

public class ShardedJedisTemplateTests {
	private JedisPoolConfig config;
	private List<JedisShardInfo> jedisShardInfos;
	private ShardedJedisPool pool;
	private ShardedJedisClient client;

	@Before
	public void init() {

		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(20);
		config.setBlockWhenExhausted(true);
		config.setMaxWaitMillis(1000);

		JedisShardInfo shard1 = new JedisShardInfo("lnk1982.cafe24.com", 6300);
		JedisShardInfo shard2 = new JedisShardInfo("lnk1982.cafe24.com", 6301);
		JedisShardInfo shard3 = new JedisShardInfo("lnk1982.cafe24.com", 6302);

		jedisShardInfos = new ArrayList<>();
		jedisShardInfos.add(shard1);
		jedisShardInfos.add(shard2);
		jedisShardInfos.add(shard3);

		pool = new ShardedJedisPool(config, jedisShardInfos);
		client = new ShardedJedisClient();
		client.setShardedJedisPool(pool);
	}
//	@Before
//	public void init() {
//		config = new JedisPoolConfig();
//		config.setMaxTotal(20);
//		config.setBlockWhenExhausted(true);
//		config.setMaxWaitMillis(1000);
//
//		JedisShardInfo shard1 = new JedisShardInfo("lnk1982.cafe24.com", 6300);
//		JedisShardInfo shard2 = new JedisShardInfo("lnk1982.cafe24.com", 6301);
//		JedisShardInfo shard3 = new JedisShardInfo("lnk1982.cafe24.com", 6302);
//
//		jedisShardInfos = new ArrayList<>();
//		jedisShardInfos.add(shard1);
//		jedisShardInfos.add(shard2);
//		jedisShardInfos.add(shard3);
//
//		pool = new ShardedJedisPool(config, jedisShardInfos);
//		template = new ShardedJedisTemplate();
//		template.setShardedJedisPool(pool);
//	}

	@Test
	public void shardedJedisTemplateCallbackTest() {
		String status = client.set("test:key", "testvalue");
		Assert.assertEquals("OK", status);
	}

	@Test
	public void shardedJedisTemplateReturnedCallbackTest() {
		String value = client.get("test:key");
		Assert.assertNotNull(value);
		Assert.assertEquals("testvalue", value);
	}

	@Test
	public void shardTest() {
		for (int i = 0; i < 10; i++) {
			String status = client.set("test:key" + i, "testvalue");
			System.out.println(status);
		}
	}
}