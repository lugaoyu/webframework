package com.gaoyu.bootstrap;

public class OrderMgrImpl implements OrderMgr
{

    @Override
    public void subscrible()
    {
        System.out.println("开始订阅...");
    }

    @Override
    public void unSubscrible()
    {
        System.out.println("取消订阅...");
    }
    
}
