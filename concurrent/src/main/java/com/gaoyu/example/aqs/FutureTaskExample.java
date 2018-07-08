package com.gaoyu.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FutureTaskExample
{
        public static final Logger LOG = LoggerFactory.getLogger(FutureTaskExample.class);
        
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
                FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
                new Thread(futureTask).start();
                LOG.info("do something in main");
                Thread.sleep(1000);
                String result = futureTask.get();
                LOG.info("result:{}",result);
        }
}
