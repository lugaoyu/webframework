package com.gaoyu.example.lock;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.gaoyu.annoations.ThreadSafe;

/**
 * 
 * ClassName: CountExample4 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月25日 下午11:34:24 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.8
 */
@ThreadSafe
public class LockExample3
{
        private final Map<String, Data> map = new TreeMap<>();
        
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        
        private final Lock readLock = lock.readLock();
        
        private final Lock writeLock = lock.writeLock();
        
        public Data get(String key)
        {
                readLock.lock();
                try
                {
                        return map.get(key);
                }
                finally
                {
                        readLock.unlock();
                }
        }
        
        public Set<String> getAllKeys()
        {
                readLock.lock();
                try
                {
                        return map.keySet();
                }
                finally
                {
                        readLock.unlock();
                }
        }
        
        public Data put(String key, Data value)
        {
                writeLock.lock();  //执行时，读锁应该结束，否则写锁一直等待
                try
                {
                        return map.put(key, value);
                }
                finally
                {
                        readLock.unlock();
                }
        }
        
        class Data
        {
                
        }
}
