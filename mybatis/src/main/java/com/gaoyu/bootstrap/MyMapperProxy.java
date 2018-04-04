package com.gaoyu.bootstrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MyMapperProxy<T> implements InvocationHandler
{
    private SqlSession sqlSession;
    private Class<T> mapperInterface;
    
    public MyMapperProxy(SqlSession sqlSession,Class<T> mapperInterface)
    {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {   
        List<T> list = sqlSession.selectList(mapperInterface.getCanonicalName()+"."+method.getName());
        System.out.println(mapperInterface.getCanonicalName()+"."+method.getName());
        return list;
    }
    
}
