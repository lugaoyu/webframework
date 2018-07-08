package com.gaoyu.example.immutable;

import java.util.HashMap;
import java.util.Map;

import com.gaoyu.annoations.NotThreadSafe;

/**
 * 
 *不可变对象 final
 * date: 2018年5月26日 上午10:55:10 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */

@NotThreadSafe
public class ImmutableExample1
{
        @SuppressWarnings("unused")
        private final static Integer a = 1; //初始化后不能再修改
        @SuppressWarnings("unused")
        private final static String b = "2";
        private final static Map<Integer,Integer> map = new  HashMap<Integer, Integer>();
        
        static
        {
                map.put(1, 2);
                map.put(3, 4);
                map.put(5, 6);
        }
        
        public static void main(String[] args)
        {
                //a =2;
                //b = "3";
                //map = new HashMap<Integer, Integer>(); 不能再指向另外的对象
               //但可以改变对象里面的键值对的值
                map.put(1, 3);
                System.out.println(map.get(1)); //有线程安全问题
        }
        
        @SuppressWarnings("unused")
        private void test(final int a)
        {
               // a = 2;
               // 传入的基础对象a不能在被修改
        }
}
