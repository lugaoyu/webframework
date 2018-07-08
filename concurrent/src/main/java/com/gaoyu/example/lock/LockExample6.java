package com.gaoyu.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.example.aqs.CyclicBarrierExample1;


public class LockExample6
{
        public static final Logger LOG =
                LoggerFactory.getLogger(CyclicBarrierExample1.class);
        
        public static void main(String[] args)
        {
                ReentrantLock reentrantLock = new ReentrantLock();
                Condition condition = reentrantLock.newCondition();
                
                new Thread(() -> {
                        try
                        {
                                reentrantLock.lock();
                                LOG.info("wait signal"); // 1
                                condition.await();
                        }
                        catch (InterruptedException e)
                        {
                                e.printStackTrace();
                        }
                        LOG.info("get signal"); // 4
                        reentrantLock.unlock();
                }).start();
                
                new Thread(() -> {
                        reentrantLock.lock();
                        LOG.info("get lock"); // 2
                                try
                                {
                                        Thread.sleep(3000);
                                }
                                catch (InterruptedException e)
                                {
                                        e.printStackTrace();
                                }
                                condition.signalAll();
                                LOG.info("send signal ~ "); // 3
                                reentrantLock.unlock();
                        }).start();
        }
}
