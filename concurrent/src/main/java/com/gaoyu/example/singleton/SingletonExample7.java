package com.gaoyu.example.singleton;

import com.gaoyu.annoations.Recommend;
import com.gaoyu.annoations.ThreadSafe;

/**
 * 枚举模式：最安全
 * date: 2018年5月26日 上午10:24:15 <br/>
 *
 * @author gaoyu
 * 
 */
@ThreadSafe
@Recommend
public class SingletonExample7
{
        private SingletonExample7()
        {
        }
        
        public static SingletonExample7 getInstance()
        {
                return Singleton.INSTANCE.getInstance();
        }
        
        private enum Singleton
        {
                INSTANCE;
                
                private SingletonExample7 singleton;
                
                Singleton()
                {
                        singleton = new SingletonExample7();//jvm保证只被实例化一次
                }
                
                public SingletonExample7 getInstance()
                {
                        return singleton;
                }
        }
        
}
