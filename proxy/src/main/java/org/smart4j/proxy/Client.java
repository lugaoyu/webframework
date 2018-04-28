package org.smart4j.proxy;

import org.smart4j.proxy.joggle.Greeting;
import org.smart4j.proxy.joggle.impl.GreetImpl;
import org.smart4j.proxy.joggle.impl.GreetingAroundAdvice;
/*import org.smart4j.proxy.joggle.impl.GreetingAfterAdvice;
import org.smart4j.proxy.joggle.impl.GreetingBeforeAdvice;*/
import org.smart4j.proxy.joggle.impl.GreetingBeforeAndAfterAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * AOP
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class Client
{
    public static void main(String[] args){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetImpl());
       /* proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());*/
        //proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());//环绕增强
        Greeting greeting = (Greeting)proxyFactory.getProxy();
        greeting.say("lwx");
    }
}
