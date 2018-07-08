package com.gaoyu.exceptions;

/**
 * 
 * ClassName: ShopOperationException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 下午2:52:54 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class ShopOperationException extends Exception
{
        private static final long serialVersionUID = 2361446884822298905L;
        
        public ShopOperationException(String msg)
        {
                super(msg);
        }
}
