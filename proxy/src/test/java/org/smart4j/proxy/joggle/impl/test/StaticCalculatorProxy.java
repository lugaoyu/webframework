package org.smart4j.proxy.joggle.impl.test;

import org.smart4j.proxy.joggle.test.Calculator;
/**
 * 静态代理类定义
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.18
 */
public class StaticCalculatorProxy implements Calculator
{
    private Calculator obj;
    public StaticCalculatorProxy(Calculator obj)
    {
        this.obj = obj;
    }
    public Integer add(Integer num1, Integer num2)
    {
        before();
        Integer result = obj.add(num1, num2);
        after();
        return result;
    }
    
    public Integer minus(Integer num1, Integer num2)
    {
        before();
        Integer result = obj.minus(num1, num2);
        after();
        return result;
    }
    
    private void before()
    {
        System.out.println("调用目标方法增强前");
    }
    
    private void after()
    {
        System.out.println("调用目标方法增强后");
    }
}
