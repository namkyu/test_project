package redis.template.core;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.template.exception.RedisException;

public class ShardedJedisTemplate {


	public static <T> T execute(ShardedJedisPool jedisPool, ShardedJedisReturnedCallback<T> shardedJedisReturnedCallback) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = jedisPool.getResource();
			T returnValue = shardedJedisReturnedCallback.doInShardedJedis(shardedJedis);
			return returnValue;
		} catch (JedisConnectionException e) {
			if (shardedJedis != null) {
				jedisPool.returnBrokenResource(shardedJedis);
			}
			throw new RedisException(e.getMessage(), e);

		} finally {
			if (shardedJedis != null) {
				jedisPool.returnResource(shardedJedis);
			}
		}
	}
}
