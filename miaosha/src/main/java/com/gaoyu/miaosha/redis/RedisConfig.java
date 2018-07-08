package com.gaoyu.miaosha.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: RedisConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:50:54 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Component
// 扫描配置文件里以redis开头的配置项信息
@ConfigurationProperties(prefix = "redis")
public class RedisConfig
{
        private String host;
        
        private int port;
        
        private int timeout;
        
        private String password;
        
        private int poolMaxTotal;
        
        private int poolMaxIdle;
        
        private int poolMaxWait;
        
        public String getHost()
        {
                return host;
        }
        
        public void setHost(String host)
        {
                this.host = host;
        }
        
        public int getPort()
        {
                return port;
        }
        
        public void setPort(int port)
        {
                this.port = port;
        }
        
        public int getTimeout()
        {
                return timeout;
        }
        
        public void setTimeout(int timeout)
        {
                this.timeout = timeout;
        }
        
        public String getPassword()
        {
                return password;
        }
        
        public void setPassword(String password)
        {
                this.password = password;
        }
        
        public int getPoolMaxTotal()
        {
                return poolMaxTotal;
        }
        
        public void setPoolMaxTotal(int poolMaxTotal)
        {
                this.poolMaxTotal = poolMaxTotal;
        }
        
        public int getPoolMaxIdle()
        {
                return poolMaxIdle;
        }
        
        public void setPoolMaxIdle(int poolMaxIdle)
        {
                this.poolMaxIdle = poolMaxIdle;
        }
        
        public int getPoolMaxWait()
        {
                return poolMaxWait;
        }
        
        public void setPoolMaxWait(int poolMaxWait)
        {
                this.poolMaxWait = poolMaxWait;
        }
}
