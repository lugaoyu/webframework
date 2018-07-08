package com.gaoyu.example.syncContainer;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.ThreadSafe;

/**
 * 同步容器
 * ClassName: ArrayListExample <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午3:18:41 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@ThreadSafe
public class VectorExample1
{
  public static final Logger LOG = LoggerFactory.getLogger(VectorExample1.class);
        
        public static final int clientThread = 5000;
        
        public static final int threadThread = 200;
        
        public static List<Integer> list  = new Vector<Integer>();
        
        public static void main(String[] args) throws InterruptedException
        {
                //线程池
                ExecutorService executorService = Executors.newCachedThreadPool();
                //信号量
                final Semaphore semaphore = new Semaphore(threadThread);
                //计数器闭锁
                final CountDownLatch countDownLatch = new CountDownLatch(threadThread);
                
                for(int i=0 ; i<clientThread;i++)
                {
                        final int count = i;
                        executorService.execute(() -> {
                                try
                                {
                                        semaphore.acquire();
                                        update(count);
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
                LOG.info("size:{}",list.size());
        }
        
        public static void update(int i)
        {
               list.add(i);
        }
}
