package redis.template.core;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class ShardedJedisClient {

	protected ShardedJedisPool shardedJedisPool;

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	public String set(final String key, final String value) {
		return execute(new ShardedJedisReturnedCallback<String>() {
			@Override public String doInShardedJedis(ShardedJedis shardedJedis) {
				return shardedJedis.set(key, value);
			}
		});
	}

	public String get(final String key) {
		return execute(new ShardedJedisReturnedCallback<String>() {
			@Override public String doInShardedJedis(ShardedJedis shardedJedis) {
				return shardedJedis.get(key);
			}
		});
	}

	public <T> T execute(ShardedJedisReturnedCallback<T> shardedJedisReturnedCallback) {
		return ShardedJedisTemplate.execute(shardedJedisPool, shardedJedisReturnedCallback);
	}
}
