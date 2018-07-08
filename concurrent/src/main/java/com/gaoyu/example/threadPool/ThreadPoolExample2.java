package com.gaoyu.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName: ThreadPoolExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午10:20:24 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class ThreadPoolExample2
{
        private static final Logger LOG = LoggerFactory.getLogger(ThreadPoolExample2.class);
        public static void main(String[] args) throws InterruptedException
        {
                ExecutorService executorService = Executors.newFixedThreadPool(3);
                for(int i=0; i<10; i++)
                {
                        final int index = i;
                       
                        Thread.sleep(1000);
                        executorService.execute(()-> {
                                LOG.info("{}:",Thread.currentThread().getName());
                                LOG.info("index:{}",index);
                        });
                }
                executorService.shutdown();
        }
}
