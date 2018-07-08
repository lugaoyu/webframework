package com.gaoyu.example.commonUnsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.NotThreadSafe;

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
@NotThreadSafe
public class StringExample1
{
        public static final Logger LOG = LoggerFactory.getLogger(StringExample1.class);
        
        public static final int clientThread = 5000;
        
        public static final int threadThread = 200;
        
        public static StringBuilder stringBuilder  = new StringBuilder();
        
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
                LOG.info("size:{}",stringBuilder.length());
        }
        
        public static void add()
        {
               stringBuilder.append("1");
        }
}
