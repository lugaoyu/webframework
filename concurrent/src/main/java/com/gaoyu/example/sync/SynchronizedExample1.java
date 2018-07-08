package com.gaoyu.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName: SynchronizedExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月25日 下午11:20:52 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.8
 */
public class SynchronizedExample1
{
        private static final Logger LOG = LoggerFactory.getLogger(SynchronizedExample1.class);
        
        //修饰一个代码块
        public void test1(int j)
        {
                /**
                 * 第一种情况
                 *     executorService.execute(() -> {
                                example1.test1(1);
                         });
                         
                         //
                         executorService.execute(() -> {
                                example1.test1(1);
                });
                 *   this== example1对象 
                 *   被同时调用两次  会被锁住 同步操作
                 * 
                 */
                
              /**
               *  第二种情况
                 *     executorService.execute(() -> {
                                example1.test1(1);
                         });
                         
               *       executorService.execute(() -> {
                                example2.test1(2);
                         });
               * 
               *    this分别是不同的对象 之间互不干扰 异步交叉执行
               *    谁抢到时间片 谁先执行
               */
                synchronized (this) 
                {
                        for(int i=0;i<10;i++)
                        {
                                LOG.info("test1 - {}-{}",j,i);
                        }
                }
        }
        
        //修饰一个方法
        public synchronized void test2()
        {
                for(int i=0 ;i<10;i++)
                {
                        LOG.info("test2 - {}", i);
                }
        }
        
        public static void main(String[] args)
        {
                SynchronizedExample1 example1 = new SynchronizedExample1();
                SynchronizedExample1 example2 = new SynchronizedExample1();
                ExecutorService executorService = Executors.newCachedThreadPool();
                executorService.execute(() -> {
                        example1.test2();
                });
                executorService.execute(() -> {
                        example2.test2();
                });
        }

}
