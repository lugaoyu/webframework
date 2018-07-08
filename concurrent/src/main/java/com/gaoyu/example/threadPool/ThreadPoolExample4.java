package com.gaoyu.example.threadPool;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ThreadPoolExample4
{
        private static final Logger LOG = LoggerFactory.getLogger(ThreadPoolExample4.class);
        
        public static void main(String[] args)
        {
                
                ScheduledExecutorService executorService =
                        Executors.newScheduledThreadPool(1);
                
                // executorService.schedule(new Runnable() {
                // @Override
                // public void run() {
                // log.warn("schedule run");
                // }
                // }, 3, TimeUnit.SECONDS);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
                System.err.println(df.format(System.currentTimeMillis()));  
                        executorService.scheduleAtFixedRate(new Runnable()
                        {
                                @Override
                                public void run()
                                {
                                        LOG.info("****"+Thread.currentThread().getName()+"schedule run");
                                }
                        }, 3, 5, TimeUnit.SECONDS); //延迟3秒，间隔5秒 
                
                // executorService.shutdown();
                
                /*Timer timer = new Timer();
                timer.schedule(new TimerTask()
                {
                        @Override
                        public void run()
                        {
                                LOG.warn("timer run");
                        }
                }, new Date(), 5 * 1000);*/
        }
}
