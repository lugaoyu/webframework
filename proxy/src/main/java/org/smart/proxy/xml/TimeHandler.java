package org.smart.proxy.xml;
/**
 * 横切关注点(增强的方法一)
 * @author lWX379193
 * @since  1.0.1
 * @data   2017.08.22
 */
public class TimeHandler
{
    public void printTime()
    {
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    } 
}
