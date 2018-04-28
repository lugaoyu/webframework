package org.smart.proxy.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户端
 * @author lWX379193
 * @since  1.0.1
 * @data   2017.08.22
 */
public class App
{
    public static void main(String[] args){
        @SuppressWarnings("resource")
        ApplicationContext context  = new ClassPathXmlApplicationContext("/aop.xml");
        HelloWorld helloWorldProxy1 = (HelloWorld)context.getBean("helloWorldImpl1");
        HelloWorld helloWorldProxy2 = (HelloWorld)context.getBean("helloWorldImpl2");
        helloWorldProxy1.printHelloWorld();
        System.out.println();
        helloWorldProxy1.doPrint();
        System.out.println();
        helloWorldProxy2.printHelloWorld();
        System.out.println();
        helloWorldProxy2.doPrint();
    }
}
