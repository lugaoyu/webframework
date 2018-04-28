package org.smart4j.proxy;

import org.smart4j.proxy.joggle.Hello;
import org.smart4j.proxy.joggle.impl.HelloImpl;

/**
 * 接口代理类(静态代理)
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class HelloProxy implements Hello
{
    private Hello hello;
    public HelloProxy(){
        hello = new HelloImpl();
    }
    
    
    public void say(String name){
        before();
        hello.say(name);
        after();
    }

    private void before(){
        System.out.println("调用目标方法增强前");
    }
    
    private void after(){
        System.out.println("调用目标方法增强后");
    }
}
