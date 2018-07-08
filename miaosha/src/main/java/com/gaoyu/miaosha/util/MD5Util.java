package com.gaoyu.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * ClassName: MD5Util <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午9:50:33 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
public class MD5Util
{
        public static String md5(String src)
        {
                return DigestUtils.md5Hex(src);
        }
        
        private static final String salt = "1a2b3c4d";
        
        public static String inputPassFormPass(String inputPass)
        {
                String str = "" + salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
                return md5(str);
        }
        
        public static String formPassToDBPass(String inputPass, String saltDB)
        {
                String str = "" + saltDB.charAt(0)+saltDB.charAt(2)+inputPass+saltDB.charAt(5)+saltDB.charAt(4);
                return md5(str);
        }
        
        public static void main(String[] args)
        {
                System.out.println(inputPassFormPass("d3b1294a61a07da9b49b6e22b2cbd7f9"));
        }
        
}