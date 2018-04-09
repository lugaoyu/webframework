package com.gaoyu.bootstrap;

public class ValidateImpl implements Validate
{
    @Override
    public void validateParam()
    {
       System.out.println("参数校验通过...");
    }

    @Override
    public void returnResult()
    {
        System.out.println("返回结果...");
    }
}
