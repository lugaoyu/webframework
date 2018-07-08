package com.gaoyu.example.singleton;

import com.gaoyu.annoations.NotThreadSafe;

/**指令重排
 * date: 2018年5月26日 上午10:24:15 <br/>
 *
 * @author gaoyu
 * 
 */
@NotThreadSafe
public class SingletonExample4
{
        private SingletonExample4()
        {
                
        }
        
        //1  memory = allocate()分配对象内存空间
        //2  ctorInstance() 初始化对象
       //3  instance = memory 设置instance指向刚分配的内存
        
        //jvm和cpu优化 发生了指令重排
        //1  memory = allocate()分配对象内存空间
        //3  ctorInstance() 初始化对象
       //2  instance = memory 设置instance指向刚分配的内存
        
        private static SingletonExample4 instance = null;
        
        //静态工厂方法
        public static  SingletonExample4 getInstance()
        {
                if( null == instance) //双重检测机制
                {
                        synchronized (SingletonExample4.class)//同步锁
                        {
                                if(null == instance)
                                {
                                        instance = new SingletonExample4();
                                }
                        }
                }
                return instance;
        }
}
