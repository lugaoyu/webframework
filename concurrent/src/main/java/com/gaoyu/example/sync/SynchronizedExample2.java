package com.gaoyu.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 同一个时间 只有一个线程得以执行  同步执行
 * ClassName: SynchronizedExample1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月25日 下午11:20:52 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.8
 */
public class SynchronizedExample2
{
        private static final Logger LOG = LoggerFactory.getLogger(SynchronizedExample2.class);
        
        //修饰一个类
        public static void test1(int j)
        {
                synchronized (SynchronizedExample2.class) 
                {
                        for(int i=0;i<10;i++)
                        {
                                LOG.info("test1 - {}-{}",j,i);
                        }
                }
        }
        
        //修饰一个静态方法
        /**
         * 锁住的是所有对象
         * 同一个时间 只有一个线程得以执行  同步执行
         * test2:(这里用一句话描述这个方法的作用). <br/>
         * TODO(这里描述这个方法适用条件 – 可选).<br/>
         * TODO(这里描述这个方法的执行流程 – 可选).<br/>
         * TODO(这里描述这个方法的使用方法 – 可选).<br/>
         * TODO(这里描述这个方法的注意事项 – 可选).<br/>
         *
         * @author gaoyu
         * @param j
         * @since JDK 1.7
         */
        public static synchronized void test2(int j)
        {
                for(int i=0 ;i<10;i++)
                {
                        LOG.info("test2 - {} - {}",j, i);
                }
        }
        
        @SuppressWarnings("static-access")
        public static void main(String[] args)
        {
                SynchronizedExample2 example1 = new SynchronizedExample2();
                SynchronizedExample2 example2 = new SynchronizedExample2();
                ExecutorService executorService = Executors.newCachedThreadPool();
                executorService.execute(() -> {
                        example1.test2(1);
                });
                executorService.execute(() -> {
                        example2.test2(2);
                });
        }

}
