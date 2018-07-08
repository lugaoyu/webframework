package com.gaoyu.example.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.ThreadSafe;
import com.gaoyu.example.aqs.CyclicBarrierExample1;


@ThreadSafe
public class LockExample5
{
        
        public static final Logger LOG =
                LoggerFactory.getLogger(CyclicBarrierExample1.class);
        
        // 请求总数
        public static int clientTotal = 5000;
        
        // 同时并发执行的线程数
        public static int threadTotal = 200;
        
        public static int count = 0;
        
        private final static StampedLock lock = new StampedLock();
        
        public static void main(String[] args)
                throws Exception
        {
                ExecutorService executorService =
                        Executors.newCachedThreadPool();
                final Semaphore semaphore = new Semaphore(threadTotal);
                final CountDownLatch countDownLatch =
                        new CountDownLatch(clientTotal);
                for (int i = 0; i < clientTotal; i++)
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
                                        LOG.error("exception", e);
                                }
                                countDownLatch.countDown();
                        });
                }
                countDownLatch.await();
                executorService.shutdown();
                LOG.info("count:{}", count);
        }
        
        private static void add()
        {
                long stamp = lock.writeLock();
                try
                {
                        count++;
                }
                finally
                {
                        lock.unlock(stamp);
                }
        }
}
