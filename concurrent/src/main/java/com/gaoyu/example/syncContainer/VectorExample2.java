package com.gaoyu.example.syncContainer;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.NotThreadSafe;


/**
 * 操作次序的差異  可能產生綫程不安全
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
public class VectorExample2
{
        public static final Logger LOG = LoggerFactory.getLogger(VectorExample2.class);
        
        public static final int clientThread = 5000;
        
        public static final int threadThread = 200;
        
        public static Vector<Integer> vector = new Vector<Integer>();
        
        public static void main(String[] args) throws InterruptedException
        {
                while (true)
                {
                        
                        for (int i = 0; i < 10; i++)
                        {
                                vector.add(i);
                        }
                        
                        Thread thread1 = new Thread()
                        {
                                public void run()
                                {
                                        for (int i = 0; i < vector.size(); i++)
                                        {
                                                vector.remove(i);
                                        }
                                }
                        };
                        
                        Thread thread2 = new Thread()
                        {
                                public void run()
                                {
                                        for (int i = 0; i < vector.size(); i++)
                                        {
                                                vector.get(i);
                                        }
                                }
                        };
                        
                        thread1.start();
                        thread2.start();
                }
        }
}
