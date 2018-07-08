package com.gaoyu.example.commonUnsafe;

import java.text.SimpleDateFormat;
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
public class DateFormatExample1
{
        public static final Logger LOG = LoggerFactory.getLogger(DateFormatExample1.class);
        
        public static final int clientThread = 5000;
        
        public static final int threadThread = 200;
        
        private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        
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
                                        update();
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
        }
        
        public static void update()
        {
                try
                {
                        LOG.info("{}",simpleDateFormat.parse("20180526"));
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }
        }
}
