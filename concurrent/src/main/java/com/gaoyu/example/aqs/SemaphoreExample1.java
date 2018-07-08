package com.gaoyu.example.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.example.commonUnsafe.ArrayListExample;

/**
 * 
 * ClassName: CountDownLatchExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午8:36:02 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class SemaphoreExample1
{
        public static final Logger LOG = LoggerFactory.getLogger(ArrayListExample.class);
        
        private final static int threadCount = 20;
        
        public static void main(String[] args) throws InterruptedException
        {
                ExecutorService executorService = Executors.newCachedThreadPool();
                
                final Semaphore semaphore = new Semaphore(3);
                
                for(int i=0; i<threadCount; i++)
                {
                        final int threadNum = i;
                        executorService.execute(()-> {
                                try
                                {
                                        LOG.info("--{}--",Thread.currentThread().getName());
                                        semaphore.acquire(); //獲取一個許可
                                        test(threadNum);
                                        semaphore.release();//釋放一個許可
                                }
                                catch(Exception e)
                                {
                                        LOG.error(e.getMessage());
                                }
                        });
                }
                executorService.shutdown();
        }
        
        private static void test(int threadNum) throws InterruptedException
        {
                LOG.info("**{}**",threadNum);
                Thread.sleep(1000);
        }
}
