package com.gaoyu.bootstrap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class Bootstrap 
{
    @SuppressWarnings("rawtypes")
    public static void main( String[] args ) throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        MyHandler myHandler = new MyHandler(new UserMgrImpl(),new ValidateImpl());
        UserMgr userMgrImpl =  (UserMgr)myHandler.getInstance();
        System.err.println("userMgrImpl: "+userMgrImpl.getClass());
        userMgrImpl.addUser();
        userMgrImpl.delUser();
        Class[] interfaces = {UserMgr.class};
        boolean result = ProxyUtils.saveProxyClass("D:\\proxy.class", "UserMgrImpl", interfaces);
        System.out.println(result);
        System.out.println("********");
        Method addMethod =  Class.forName("com.gaoyu.bootstrap.UserMgr").getMethod("addUser", new Class[0]);
        addMethod.invoke(userMgrImpl, args);
        System.out.println("--------");
        UserMgr userMgrImplTrue = new UserMgrImpl();
        System.out.println("userMgrImplTrue: "+userMgrImplTrue.getClass());
        userMgrImplTrue.addUser();
        System.out.println("另外一个接口代理...");
        myHandler = new MyHandler(new OrderMgrImpl(),new ValidateImpl());
        OrderMgr orderMgrImpl = (OrderMgr)myHandler.getInstance();
        System.err.println(orderMgrImpl.getClass());
        orderMgrImpl.subscrible();
        orderMgrImpl.unSubscrible();
    }
}
