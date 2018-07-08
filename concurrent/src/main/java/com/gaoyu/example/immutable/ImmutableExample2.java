package com.gaoyu.example.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.gaoyu.annoations.ThreadSafe;

/**
 * 
 * date: 2018年5月26日 上午10:55:10 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@ThreadSafe
public class ImmutableExample2
{
        private  static Map<Integer,Integer> map = new  HashMap<Integer, Integer>();
        
        static
        {
                map.put(1, 2);
                map.put(3, 4);
                map.put(5, 6);
                map = Collections.unmodifiableMap(map); //不允许修改值
        }
        
        public static void main(String[] args)
        {
                map.put(1, 3);
                System.out.println(map.get(1)); 
        }
        
}
