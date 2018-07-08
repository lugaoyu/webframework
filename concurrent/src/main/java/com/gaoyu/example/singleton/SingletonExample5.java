package com.gaoyu.example.singleton;

import com.gaoyu.annoations.ThreadSafe;

/**限制指令重排
 * date: 2018年5月26日 上午10:24:15 <br/>
 *
 * @author gaoyu
 * 
 */
@ThreadSafe
public class SingletonExample5
{
        private SingletonExample5()
        {
                
        }
        
        //1  memory = allocate()分配对象内存空间
        //2  ctorInstance() 初始化对象
       //3  instance = memory 设置instance指向刚分配的内存
        
        //volatile使用场景+双重检测机制 -》禁止指令重拍
        private volatile static SingletonExample5 instance = null;
        
        //静态工厂方法
        public static  SingletonExample5 getInstance()
        {
                if( null == instance) //双重检测机制
                {
                        synchronized (SingletonExample5.class)//同步锁
                        {
                                if(null == instance)
                                {
                                        instance = new SingletonExample5();
                                }
                        }
                }
                return instance;
        }
}
