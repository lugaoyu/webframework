package com.gaoyu.bootstrap;

public class Main
{
    public static void main(String[] args)
    {
        CgLibProxy cgLibProxy = new CgLibProxy(new ValidateImpl());
        OrderMgr orderMgrProxy = (OrderMgr)cgLibProxy.getInstance(OrderMgrImpl.class);
        System.out.println(orderMgrProxy.getClass());
        orderMgrProxy.subscrible();
        orderMgrProxy.unSubscrible();
    }
}
