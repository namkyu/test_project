package redis.template.core;

import redis.clients.jedis.ShardedJedis;

public interface ShardedJedisReturnedCallback<T> {

	T doInShardedJedis(ShardedJedis shardedJedis);

}