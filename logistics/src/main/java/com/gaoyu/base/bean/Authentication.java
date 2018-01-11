package com.gaoyu.base.bean;

/**
 * 承运商
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-12-30
 */
public class Authentication
{
    
    private long ts;
    
    private int appType;
    
    // 供外部调用提供
    private String token;
    
    // 供内部调用提供
    private String sign;
    
    public long getTs()
    {
        return ts;
    }
    
    public void setTs(long ts)
    {
        this.ts = ts;
    }
    
    public int getAppType()
    {
        return appType;
    }
    
    public void setAppType(int appType)
    {
        this.appType = appType;
    }
    
    public String getToken()
    {
        return token;
    }
    
    public void setToken(String token)
    {
        this.token = token;
    }
    
    public String getSign()
    {
        return sign;
    }
    
    public void setSign(String sign)
    {
        this.sign = sign;
    }
}
