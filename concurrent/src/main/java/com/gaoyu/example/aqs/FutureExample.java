package com.gaoyu.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FutureExample
{
        public static final Logger LOG = LoggerFactory.getLogger(FutureExample.class);
        
        static  class MyCallable implements Callable<String>
        {
                @Override
                public String call() throws Exception
                {
                        LOG.info("do something in callable");
                        Thread.sleep(5000);
                        return "Done";
                }
        }
        
        public static void main(String[] args) throws InterruptedException, ExecutionException
        {
                ExecutorService executorService = Executors.newCachedThreadPool();
                Future<String> future = executorService.submit(new MyCallable());
                LOG.info("do something in main");
                Thread.sleep(1000);
                String result = future.get();
                LOG.info("result:{}",result);
                executorService.shutdown();
        }
}
