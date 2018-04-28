package org.smart4j.proxy;

import org.smart4j.proxy.joggle.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP XML配置文件
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.17
 */
public class Client_XML
{
    @SuppressWarnings("resource")
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        Greeting greeting = (Greeting)context.getBean("greetingProxy");
        greeting.say("lwx");
    }
}
