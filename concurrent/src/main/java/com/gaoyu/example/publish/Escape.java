package com.gaoyu.example.publish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.annoations.NotRecommend;
import com.gaoyu.annoations.NotThreadSafe;

/**
 * 對象溢出
 * 在對象沒有構造出來之前，不能發佈
 * ClassName: Escape <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月26日 上午10:10:12 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@NotThreadSafe
@NotRecommend
public class Escape
{
        public static final Logger LOG = LoggerFactory.getLogger(Escape.class);
        
        private int thisCanBeEscape = 0;
        
        public Escape()
        {
                new InnerClass();
        }
        
        private class InnerClass
        {
                public InnerClass()
                {
                        LOG.info("{}", Escape.this.thisCanBeEscape);
                }
        }
        
        public static void main(String[] args)
        {
                new Escape();       
         }
}
