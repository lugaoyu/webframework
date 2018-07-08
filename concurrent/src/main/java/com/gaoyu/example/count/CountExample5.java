package com.gaoyu.example.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.NotThreadSafe;

/**
 * 线程可见性
 * ClassName: CountExample5 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 上午9:25:50 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@NotThreadSafe
public class CountExample5
{
        private static final Logger LOG = LoggerFactory.getLogger(CountExample5.class);
        
        // 请求总数
        public static int clientTotal = 5000;
        
        // 并发的线程数
        public static int threadTotal = 200;
        
        public static volatile int count = 0;
        
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
                        executorService.execute(new Runnable()
                        {
                                @Override
                                public void run()
                                {
                                        try
                                        {
                                                semaphore.acquire();
                                                add();
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
        
        public  static void add()
        {
                //1.count
                //2.+1
                //3.count
                count ++;
        }
}
