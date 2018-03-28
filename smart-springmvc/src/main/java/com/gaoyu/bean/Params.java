package com.gaoyu.bean;

import java.util.Map;

/**Params请求参数工具类
 * ClassName:Params <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月29日 上午11:12:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class Params
{
    private Map<String, Object> paramMap;
    
    public Params(Map<String, Object> paramMap)
    {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getParamMap()
    {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap)
    {
        this.paramMap = paramMap;
    }
    
}
