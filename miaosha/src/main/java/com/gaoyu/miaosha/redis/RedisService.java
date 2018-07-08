package com.gaoyu.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * 
 * ClassName: RedisService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:51:18 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
@Service
public class RedisService
{
        
        @Autowired
        JedisPool jedisPool;
        
        public <T> T getValueByKey(KeyPrefix prefix, String key, Class<T> clazz)
        {
                Jedis jedis = null;
                try
                {
                        jedis = jedisPool.getResource();
                        String realKey = prefix.getPrefix()+key;
                        String value = jedis.get(realKey);
                        T t = stringToBean(value, clazz);
                        return t;
                }
                finally
                {
                        returnToPool(jedis);
                }
        }
        
        public <T> boolean setValueUseKey(KeyPrefix prefix, String key, T value)
        {
                if (key == null || value == null)
                { 
                        return false;
                }
                Jedis jedis = null;
                try
                {
                        jedis = jedisPool.getResource();
                        String valueStr = beanToString(value);
                        int seconds = prefix.expireSeconds();
                        String realKey = prefix.getPrefix() + key;
                        if(seconds <=0)
                        {
                                jedis.set(realKey, valueStr);
                        }
                        else
                        {
                                jedis.setex(realKey, seconds, valueStr);
                        }
                        return true;
                }
                finally
                {
                        returnToPool(jedis);
                }
        }
        
        private void returnToPool(Jedis jedis)
        {
                if (jedis != null)
                {
                        jedis.close();
                }
        }
        
        private <T> String beanToString(T value)
        {
                if (value == null)
                {
                        return null;
                }
                Class<?> clazz = value.getClass();
                if (clazz == int.class || clazz == Integer.class)
                {
                        return "" + value;
                }
                else if (clazz == long.class || clazz == Long.class)
                {
                        return "" + value;
                }
                else if (clazz == String.class)
                {
                        return (String)value;
                }
                else
                {
                        return JSONObject.toJSONString(value);
                }
        }
        
        @SuppressWarnings("unchecked")
        private <T> T stringToBean(String value, Class<T> clazz)
        {
                if (value == null || clazz == null || value.length() <= 0)
                {
                        return null;
                }
                if (clazz == int.class || clazz == Integer.class)
                {
                        return (T)Integer.valueOf(value);
                }
                else if (clazz == String.class)
                {
                        return (T)value;
                }
                else if (clazz == long.class || clazz == Long.class)
                {
                        return (T)Long.valueOf(value);
                }
                else
                {
                        return JSON.toJavaObject(JSON.parseObject(value), clazz);
                }
        }
        
}
