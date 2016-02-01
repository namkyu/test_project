package redis.shard;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;

/**
 * @author <A HREF="mailto:smufu@naver.com">kris jeong</A> smufu@naver.com
 *
 * class desc
 */
public class ShardedJedisHelper {
	protected static final String SHARD1_HOST = "lnk1982.cafe24.com";
	protected static final int SHARD1_PORT = 6300;
	protected static final String SHARD2_HOST = "lnk1982.cafe24.com";
	protected static final int SHARD2_PORT = 6301;
	protected static final String SHARD3_HOST = "lnk1982.cafe24.com";
	protected static final int SHARD3_PORT = 6302;

	private ShardedJedisPool shardedPool;

	/**
	 * 싱글톤 처리를 위한 홀더 클래스, 제디스 연결풀이 포함된 도우미 객체를 반환한다.
	 */
	private static class LazyHolder {
		@SuppressWarnings("synthetic-access")
		private static final ShardedJedisHelper INSTANCE = new ShardedJedisHelper();
	}

	/**
	 * 샤딩된 제디스 연결풀 생성을 위한 도우미 클래스 내부 생성자.
	 * 싱글톤 패턴이므로 외부에서 호출할 수 없다.
	 */
	private ShardedJedisHelper() {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setBlockWhenExhausted(GenericKeyedObjectPoolConfig.DEFAULT_BLOCK_WHEN_EXHAUSTED);
		config.setMaxTotal(10);
		config.setMaxWaitMillis(100);

		int timeout = 10;
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo(SHARD1_HOST, SHARD1_PORT, timeout));
		shards.add(new JedisShardInfo(SHARD2_HOST, SHARD2_PORT, timeout));
		shards.add(new JedisShardInfo(SHARD3_HOST, SHARD3_PORT, timeout));

		this.shardedPool = new ShardedJedisPool(config, shards, Hashing.MURMUR_HASH);
	}

	/**
	 * 싱글톤 객체를 가져온다.
	 * @return 제디스 도우미객체
	 */
	@SuppressWarnings("synthetic-access")
	public static ShardedJedisHelper getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * 제디스 클라이언트 연결을 가져온다.
	 * @return 제디스 객체
	 */
	final public ShardedJedis getConnection() {
		ShardedJedis jedis = this.shardedPool.getResource();
		return jedis;
	}

//	final public void close(ShardedJedis jedis) {
//		this.shardedPool.close();
//	}

	/**
	 * 사용이 완료된 제디스 객체를 회수한다.
	 * @param jedis 사용 완료된 제디스 객체
	 */
	final public void returnResource(ShardedJedis jedis) {
		this.shardedPool.returnResource(jedis);
	}

	/**
	 * <pre>
	 * returnBrokenResource
	 *
	 * <pre>
	 * @param jedis
	 */
	final public void returnBrokenResource(ShardedJedis jedis) {
		this.shardedPool.returnBrokenResource(jedis);
	}
}
