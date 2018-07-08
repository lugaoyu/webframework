package com.gaoyu.example.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 綫程相互等待到某一点 然后触发
 * ClassName: CyclicBarrierExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午8:36:02 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class CyclicBarrierExample1
{
        public static final Logger LOG = LoggerFactory.getLogger(CyclicBarrierExample1.class);
        
        private final static int threadCount = 10;
        
        private static CyclicBarrier barrier = new CyclicBarrier(5); //同步等待
        
        public static void main(String[] args) throws InterruptedException
        {
                ExecutorService executorService = Executors.newCachedThreadPool();
                
                for(int i=0; i<threadCount; i++)
                {
                        final int threadNum = i;
                        Thread.sleep(1000);
                        executorService.execute(()-> {
                                try
                                {
                                        race(threadNum);
                                }
                                catch(Exception e)
                                {
                                        LOG.error(e.getMessage());
                                }
                        });
                }
                executorService.shutdown();
        }
        
        private static void race(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException
        {
                Thread.sleep(1000);
                LOG.info("{} is ready",threadNum);
                //barrier.await(2000,TimeUnit.MILLISECONDS);
                barrier.await();
                LOG.info("{} continue",threadNum);
        }
}
