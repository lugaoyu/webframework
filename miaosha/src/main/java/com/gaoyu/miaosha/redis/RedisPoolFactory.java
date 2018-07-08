package com.gaoyu.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 
 * ClassName: RedisPoolFactory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:51:03 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
@Service
public class RedisPoolFactory
{
        
        @Autowired
        RedisConfig redisConfig;
        
        @Bean
        public JedisPool getJedisPoolFactory()
        {
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxIdle(redisConfig.getPoolMaxIdle());
                config.setMaxTotal(redisConfig.getPoolMaxTotal());
                config.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
                JedisPool jp =
                        new JedisPool(config, redisConfig.getHost(),
                                        redisConfig.getPort(),
                                        redisConfig.getTimeout() * 1000,
                                        redisConfig.getPassword(), 0);
                return jp;
        }
        
}
