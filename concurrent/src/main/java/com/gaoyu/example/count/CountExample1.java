package com.gaoyu.example.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.ThreadSafe;

/**
 * 
 * ClassName: CountExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月25日 下午10:30:29 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.8
 */
@ThreadSafe
public class CountExample1
{
        public static final Logger LOG = LoggerFactory.getLogger(CountExample1.class);
        
        public static final int clientThread = 5000;
        
        public static final int threadThread = 200;
        
        //public static int count = 0;
        //知识点
        //compareAndSwapInt 工作内存的值和底层(主内存)的值
        public static AtomicInteger count  = new AtomicInteger(0);
        
        public static void main(String[] args) throws InterruptedException
        {
                //线程池
                ExecutorService executorService = Executors.newCachedThreadPool();
                //信号量
                final Semaphore semaphore = new Semaphore(threadThread);
                //计数器闭锁
                final CountDownLatch countDownLatch = new CountDownLatch(clientThread);
                
                for(int i=0 ; i<clientThread;i++)
                {
                        executorService.execute(() -> {
                                try
                                {
                                        semaphore.acquire();
                                        add();
                                        semaphore.release();
                                }
                                catch (Exception e)
                                {
                                     LOG.error(e.getMessage());
                                }
                                countDownLatch.countDown();
                        });
                }
                
                countDownLatch.await();
                executorService.shutdown();
                LOG.info("count:{}",count.get());
        }
        
        public static void add()
        {
                count.incrementAndGet();
        }
}
