package com.gaoyu.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

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
 * @since JDK 1.7
 */
@ThreadSafe
public class CountExample2
{
        public static final Logger LOG = LoggerFactory.getLogger(CountExample2.class);
        
        public static final int clientThread = 5000;
        
        public static final int threadThread = 200;
        
        //public static int count = 0;
        
        public static AtomicLong count  = new AtomicLong(0);
        
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
                LOG.info("count:{}",count);
        }
        
        public static void add()
        {
                // voliate value可见性
                /**
                 * do{ 1. 获取该对象偏移位置的主内存值 这个值肯定是最新的
                 * 2.比较该对象的值与期望值(主内存当前值是否相等，如果相等则update offset位置的值 也即+1)
                 * 3.如果不相等，则继续尝试，由于可见性的缘故，读取对象的值时需要从主内存同步回去
                 * 
                 * 
                 *      compareAndSet这个方法多见于并发控制中，简称CAS(Compare And
                 *      Swap)，意思是如果valueOffset位置包含的值与expect值相同
                 * ，则更新valueOffset位置的值为update，并返回true，否则不更新，返回false。
                 *      这里可以举个例子来说明compareAndSet的作用
                 * ，如支持并发的计数器，在进行计数的时候，首先读取当前的值，假设值为a，对当前值 +
                 *      1得到b，但是+1操作完以后，并不能直接修改原值为b
                 * ，因为在进行+1操作的过程中，可能会有其它线程已经对原值进行了修改，所以在更新之前需要
                 *     判断原值是不是等于a
                 * ，如果不等于a，说明有其它线程修改了
                 * ，需要重新读取原值进行操作，如果等于a，说明在+1的操作过程中，
                 *     没有其它线程来修改值，我们就可以放心的更新原值了。
                 **/
                 count.getAndIncrement();
        }
}
