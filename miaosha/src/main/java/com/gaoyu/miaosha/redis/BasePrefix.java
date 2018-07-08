package com.gaoyu.miaosha.redis;

public abstract  class BasePrefix implements KeyPrefix
{
        private int expireSeconds;
        
        private String prefix;
        
        public BasePrefix(String prefix)
        {
                this(0,prefix);
        }
        
        public  BasePrefix(int expireSeconds, String prefix)
        {
                this.expireSeconds = expireSeconds;
                this.prefix = prefix;
        }
        
        @Override
        /**
         * 默认0为永不过期
         * TODO 简单描述该方法的实现功能（可选）.
         * @see com.gaoyu.miaosha.redis.KeyPrefix#expireSeconds()
         */
        public int expireSeconds()
        {
                return expireSeconds;
        }

        @Override
        public String getPrefix()
        {
                String className = getClass().getSimpleName();
                return className + ":" + prefix;
        }

}
