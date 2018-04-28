package org.smart.proxy.xml;
/**
 * 横切关注点(增强的方法二)
 * @author lWX379193
 * @since  1.0.1
 * @data   2017.08.22
 */
public class LogHandler
{
    public void logBefore(){
        System.out.println("Log before method");
    }
    
    public void logAfter(){
        System.out.println("Log after method");
    }
}
