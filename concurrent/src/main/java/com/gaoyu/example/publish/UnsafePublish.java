package com.gaoyu.example.publish;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.NotThreadSafe;

/**
 * 发布对象概念
 * ClassName: UnsafePublish <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 上午10:06:19 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@NotThreadSafe
public class UnsafePublish
{
        public static final Logger LOG = LoggerFactory.getLogger(UnsafePublish.class);
        
        
        private String[] states = {"a","b","c"};
        
        public String[] getStates()
        {
                return states;
        }
        
        public static void main(String[] args)
        {
                UnsafePublish unsafePublish = new UnsafePublish();
                LOG.info("{}",Arrays.toString(unsafePublish.getStates()));
                
                unsafePublish.getStates()[0] = "d";
                LOG.info("{}",Arrays.toString(unsafePublish.getStates()));
        }
}
