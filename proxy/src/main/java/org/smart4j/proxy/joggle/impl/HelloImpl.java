package org.smart4j.proxy.joggle.impl;

import org.smart4j.proxy.joggle.Hello;

/**
 * 接口实现类
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class HelloImpl implements Hello
{

    public void say(String name)
    {
        System.out.println("目标方法: " + name);
    }
    
}
