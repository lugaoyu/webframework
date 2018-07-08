package com.gaoyu.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.NotThreadSafe;


/**
 * 遍歷的時候 建議不能做更新操作
 *  ClassName: ArrayListExample <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午3:18:41 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
@NotThreadSafe
public class VectorExample3
{
        public static final Logger LOG = LoggerFactory.getLogger(VectorExample3.class);
        
        //java.util.ConcurrentModificationException
        private static void test1(Vector<Integer> v1)
        {
                for(Integer i : v1)
                {
                        if(i.equals(3))
                        {
                                v1.remove(i);
                        }
                }
        }
        
        //java.util.ConcurrentModificationException
        @SuppressWarnings("unused")
        private static void test2(Vector<Integer> v1)
        {
                Iterator< Integer> iterator = v1.iterator();
                while(iterator.hasNext())
                {
                        Integer i = iterator.next();
                        if(i.equals(3))   //把i換成v1.get(i)就不會出現問題了
                        {
                                v1.remove(i);
                        }
                }
        }
        
        //success
        @SuppressWarnings("unused")
        private static void test3(Vector<Integer> v1)
        {
               for(int i= 0; i< v1.size() ; i++)
               {
                       if(v1.get(i).equals(3))
                       {
                               v1.remove(i);
                       }
               }
        }
        
        public static void main(String[] args)
        {
                Vector<Integer> vector = new Vector<Integer>();
                vector.add(1);
                vector.add(2);
                vector.add(3);
                test1(vector);
        }
}
