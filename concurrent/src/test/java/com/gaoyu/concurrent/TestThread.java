package com.gaoyu.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread
{
        public static void main(String[] args) 
        {
                ExecutorService e1 = Executors.newSingleThreadExecutor();
                ExecutorService e2 = Executors.newSingleThreadExecutor();
                e1.execute(new Runnable()
                {
                        @Override
                        public void run()
                        {
                                for(int i=0;i<10;i+=2)
                                {
                                        try
                                        {
                                                Thread.sleep(1000);
                                        }
                                        catch (InterruptedException e)
                                        {
                                                e.printStackTrace();
                                        }
                                        System.out.print(i);
                                }
                        }
                });
                e2.execute(new Runnable()
                {
                        @Override
                        public void run()
                        {
                                for(int i=1;i<10;i+=2)
                                {
                                        try
                                        {
                                                Thread.sleep(1200);
                                        }
                                        catch (InterruptedException e)
                                        {
                                                e.printStackTrace();
                                        }
                                        System.out.print(i);
                                }
                        }
                });
                e1.shutdown();
                e2.shutdown();
        }
}
