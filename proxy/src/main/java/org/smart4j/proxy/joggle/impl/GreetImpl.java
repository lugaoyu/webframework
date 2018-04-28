package org.smart4j.proxy.joggle.impl;

import org.smart4j.proxy.joggle.Greeting;


public class GreetImpl implements Greeting
{
    public void say(String name)
    {
        System.out.println("Greet: " + name);
    }
    
}
