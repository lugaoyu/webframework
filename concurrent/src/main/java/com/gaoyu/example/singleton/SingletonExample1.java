package com.gaoyu.example.singleton;

import com.gaoyu.annoations.NotThreadSafe;

/**
 * 懒汉单例模式
 * 在第一次使用时创建
 * date: 2018年5月26日 上午10:16:32 <br/>
 * @author gaoyu
 */
@NotThreadSafe
public class SingletonExample1
{
        private SingletonExample1()
        {
                //对资源的处理
                //计算运算
                //多线程下 就会有问题
        }
        
        //共享变量 存在方法区
        private static SingletonExample1 instance = null;
        
        //静态工厂方法
        public static SingletonExample1 getInstance()
        {
                if( null == instance)
                {
                        instance = new SingletonExample1();
                }
                return instance;
        }
}
