package com.gaoyu.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.ConcurrencyApplication;
import com.gaoyu.annoations.NotThreadSafe;

/**
 * 
 * ClassName: ConcurrencyTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月25日 下午10:04:36 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@NotThreadSafe
public class ConcurrencyTest
{
        private static final Logger LOG = LoggerFactory.getLogger(ConcurrencyApplication.class);
        
        // 请求总数
        public static int clientTotal = 5000;
        
        // 并发的线程数
        public static int threadTotal = 200;
        
        public static int count = 0;
        
        public static void main(String[] args) throws InterruptedException
        {
                // 线程池
                ExecutorService executorService =
                        Executors.newCachedThreadPool();
                // 信号量，每次并发的个数
                final Semaphore semaphore = new Semaphore(threadTotal);
                // 计数器闭锁
                final CountDownLatch countDownLatch =
                        new CountDownLatch(clientTotal);
                
                for (int i = 0; i < clientTotal; i++)
                {
                        final int temp = i;
                        executorService.execute(new Runnable()
                        {
                                @Override
                                public void run()
                                {
                                        LOG.info("thread_name:{}",Thread.currentThread().getName());
                                        try
                                        {
                                                semaphore.acquire();
                                                //add();
                                                System.out.println(temp);
                                                semaphore.release();
                                        }
                                        catch(Exception e)
                                        {
                                                LOG.error(e.getMessage());
                                        }
                                        countDownLatch.countDown();
                                }
                        });
                }
                //阻塞
                countDownLatch.await();
                //关闭线程池
                executorService.shutdown();
                LOG.info("count:{}",count);
        }
        
        public static void add()
        {
                count ++;
        }
}
