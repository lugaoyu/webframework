package com.gaoyu.intf;

import java.io.IOException;

/**
 * date: 2018年7月7日 下午1:43:57 <br/>
 * @author gaoyu
 */
public interface Server
{
        public void stop();
        
        public void start() throws IOException;
        
        @SuppressWarnings("rawtypes")
        public void register(Class serviceInterface, Class impl);
        
        public boolean isRunning();
        
        public int getPort();
}
