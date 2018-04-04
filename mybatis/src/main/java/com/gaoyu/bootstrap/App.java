package com.gaoyu.bootstrap;

import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.gaoyu.simple.mapper.BaseMapperTest;
import com.gaoyu.simple.mapper.UserMapper;
import com.gaoyu.simple.model.SysUser;

/**
 * Hello world!
 *
 */
public class App extends BaseMapperTest
{
    @Test
    public void proxy()
    {
        SqlSession sqlSession = getSqlSession();
        MyMapperProxy<UserMapper> userMapperProxy = new MyMapperProxy<UserMapper>(sqlSession, UserMapper.class);
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class}, userMapperProxy);
        List<SysUser> users = userMapper.selectAll();
        users.forEach(user -> System.out.println(user.getId()));
    }
    
}
