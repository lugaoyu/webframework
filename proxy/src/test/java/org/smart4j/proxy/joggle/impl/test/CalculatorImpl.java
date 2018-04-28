package org.smart4j.proxy.joggle.impl.test;

import org.smart4j.proxy.joggle.test.Calculator;
/**
 * 被代理类定义
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.18
 */
public class CalculatorImpl implements Calculator
{
    public Integer add(Integer num1, Integer num2)
    {
        int ret = num1 + num2;
        System.out.println("add_ret: " + ret);
        return ret;
    }
    
    public Integer minus(Integer num1, Integer num2)
    {
        int ret = num1 - num2;
        System.out.println("minus_ret: " + ret);
        return ret;
    }
    
}
