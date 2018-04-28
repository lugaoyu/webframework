package org.smart4j.proxy.test;

import java.lang.reflect.Proxy;

import org.smart4j.proxy.joggle.impl.test.CalculatorImpl;
import org.smart4j.proxy.joggle.impl.test.DynomicCalculatorHandler;
import org.smart4j.proxy.joggle.test.Calculator;
import org.smart4j.proxy.test.util.ProxyUtils;

/**
 * 客户端
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.18
 */
public class DynomicCalculatorProxyApp
{
    public static void main(String[] args)
    {
        Calculator obj = new CalculatorImpl();
        DynomicCalculatorHandler handler = new DynomicCalculatorHandler(obj);
        Calculator proxy =
            (Calculator)Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler);
        proxy.add(20, 10);
        proxy.minus(20, 10);
        @SuppressWarnings("rawtypes")
        Class[] interfaces = {Calculator.class};
        boolean result = ProxyUtils.saveProxyClass("D:\\proxy.txt", "CalculatorImpl", interfaces);
        System.out.println(result);
    }
}
