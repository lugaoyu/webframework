package com.gaoyu.example.singleton;

import com.gaoyu.annoations.ThreadSafe;

/**
 * date: 2018年5月26日 上午10:24:15 <br/>
 *
 * @author gaoyu
 * 
 */
@ThreadSafe
public class SingletonExample6
{
        private SingletonExample6()
        {
                System.out.println("SingletonExample6");
        }
        
        static
        {
                System.out.println("static begin");
                instance = new SingletonExample6();
                System.out.println("static end");
        }
        
        //这步顺序有问题 会抛出空指针异常 实例会被重新赋值
        
        private  static SingletonExample6 instance = null;
        
        //静态工厂方法
        public static  SingletonExample6 getInstance()
        {
                System.out.println("getInstance");
                return instance;
        }
        
        public static void main(String[] args)
        {
                System.out.println(getInstance());
                System.out.println(getInstance());
        }
}
