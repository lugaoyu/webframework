package com.gaoyu.miaosha.redis;

public class MiaoshaUserKey extends BasePrefix
{

        private static final int seconds = 3600 * 24 * 2;
        
        private MiaoshaUserKey (int seconds,String prefix)
        {
                super(seconds,prefix);
        }
        
        public static MiaoshaUserKey token = new MiaoshaUserKey(seconds,"token");
      
}
