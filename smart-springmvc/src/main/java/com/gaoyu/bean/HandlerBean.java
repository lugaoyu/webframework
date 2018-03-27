package com.gaoyu.bean;

/**封装Requestmapping的实体
 * ClassName:ReflectionUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 下午20:03:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class HandlerBean
{
    private String urlValue;
    private String requestMethod;

    public String getUrlValue()
    {
        return urlValue;
    }
    public void setUrlValue(String urlValue)
    {
        this.urlValue = urlValue;
    }
    public String getRequestMethod()
    {
        return requestMethod;
    }
    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("url={");
        builder.append(urlValue);
        builder.append("};requestMethod={");
        builder.append(requestMethod);
        builder.append("}");
        return builder.toString();
    }
}
