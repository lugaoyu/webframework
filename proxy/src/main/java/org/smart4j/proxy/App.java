package org.smart4j.proxy;

import org.smart4j.proxy.joggle.Hello;

/**
 * 客户端
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class App 
{
    public static void main( String[] args )
    {
        Hello hello = new HelloProxy();
        hello.say("lwx");
    }
}
