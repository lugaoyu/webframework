package com.gaoyu.example.threadLocal;

/**
 * 
 * ClassName: RequestHolder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 下午12:53:53 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class RequestHolder
{
        private final static ThreadLocal<Long> requestHolder = new ThreadLocal<Long>();
        
        public static void add(long id)
        {
                requestHolder.set(id);
        }
        
        public static Long getId()
        {
                return requestHolder.get();
        }
        
        public static void remove()
        {
                requestHolder.remove();
        }
}
