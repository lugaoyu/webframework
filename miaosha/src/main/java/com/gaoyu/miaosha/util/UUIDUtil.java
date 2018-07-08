package com.gaoyu.miaosha.util;

import java.util.UUID;

/**
 * 
 * ClassName: UUIDUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午9:51:00 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class UUIDUtil
{
        public static String getUUID()
        {
                return UUID.randomUUID().toString();
        }
}
