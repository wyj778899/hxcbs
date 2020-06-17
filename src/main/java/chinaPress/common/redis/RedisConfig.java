package chinaPress.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{

	private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

	@Autowired
	private RedisProperties redisProperties;
    @Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool注入成功！！");
        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(config, redisProperties.getHost(), redisProperties.getPort(), 30000,
        		redisProperties.getPassword(), 0);
        return jedisPool;
    }
}
