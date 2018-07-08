package com.gaoyu.example.singleton;

import com.gaoyu.annoations.ThreadSafe;

/**
 * 饿汉单例模式
 * 在类装载使用时创建
 * date: 2018年5月26日 上午10:19:22 <br/>
 * @author gaoyu
 */
@ThreadSafe
public class SingletonExample2
{
        //私有构造函数
        private SingletonExample2()
        {
                //如果构造方法中,存在过多的处理，加载起来特别慢
        }
        
        private static SingletonExample2 singletonExample2 = new SingletonExample2();
        
        //静态工厂方法
        public static SingletonExample2 getInstance()
        {
                return singletonExample2;
        }
}
