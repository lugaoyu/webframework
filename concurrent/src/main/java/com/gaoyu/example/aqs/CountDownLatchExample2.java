package com.gaoyu.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.example.commonUnsafe.ArrayListExample;

/**
 * 指定時間内 然後就不等其他綫程了
 * ClassName: CountDownLatchExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午8:36:02 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class CountDownLatchExample2
{
        public static final Logger LOG = LoggerFactory.getLogger(ArrayListExample.class);
        
        private final static int threadCount = 200;
        
        public static void main(String[] args) throws InterruptedException
        {
                ExecutorService executorService = Executors.newCachedThreadPool();
                
                final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
                
                for(int i=0; i<threadCount; i++)
                {
                        final int threadNum = i;
                        Thread.sleep(1);
                        executorService.execute(()-> {
                                try
                                {
                                        test(threadNum);
                                }
                                catch(Exception e)
                                {
                                        LOG.error(e.getMessage());
                                }
                                finally
                                {
                                        countDownLatch.countDown();
                                }
                        });
                }
                //
                countDownLatch.await(10,TimeUnit.MILLISECONDS); //給定時間的等待
                LOG.info("finish");
                executorService.shutdown();
        }
        
        private static void test(int threadNum) throws InterruptedException
        {
                Thread.sleep(100);
                LOG.info("{}",threadNum);
        }
}
