package org.smart4j.proxy.test;

import org.smart4j.proxy.joggle.impl.test.CalculatorImpl;
import org.smart4j.proxy.joggle.impl.test.StaticCalculatorProxy;
import org.smart4j.proxy.joggle.test.Calculator;

/**
 * 客户端
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.18
 */
public class StaticCalculatorProxyApp
{
    public static void main(String[] args){
        Calculator calculator = new CalculatorImpl();
        StaticCalculatorProxy calculatorProxy = new StaticCalculatorProxy(calculator);
        calculatorProxy.add(20, 10);
        calculatorProxy.minus(20, 10);
    }
}
