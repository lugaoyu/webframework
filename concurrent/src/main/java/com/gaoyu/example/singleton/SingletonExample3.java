package com.gaoyu.example.singleton;

import com.gaoyu.annoations.NotRecommend;
import com.gaoyu.annoations.ThreadSafe;

/**
 * 懒汉模式线程安全
 * date: 2018年5月26日 上午10:24:15 <br/>
 *
 * @author gaoyu
 * 
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3
{
        private SingletonExample3()
        {
                
        }
        
        private static SingletonExample3 instance = null;
        
        //静态工厂方法
        public static synchronized SingletonExample3 getInstance()
        {
                //带来性能上面的开销
                if( null == instance)
                {
                        instance = new SingletonExample3();
                }
                return instance;
        }
}
