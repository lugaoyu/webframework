package com.gaoyu.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.gaoyu.simple.model.SysRole;
import com.gaoyu.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest
{
    @Test
    public void testSelectById()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = mapper.selectById(1L);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());
        }
        finally
        {
            sqlSession.close();
        }
    }
    
    @Test
    public void testSelectAll()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sList = userMapper.selectAll();
            Assert.assertNotNull(sList);
            Assert.assertTrue(sList.size() > 0);
        }
        finally
        {
            sqlSession.close();
        }
    }
    
    @Test
    public void testSelectAll2()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> selectAll2 = userMapper.selectAll2();
            Assert.assertNotNull(selectAll2);
            Assert.assertTrue(selectAll2.size() > 0);
        }
        finally
        {
            sqlSession.close();
        }
    }
    
    @Test
    public void testselectRolesByUserId()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesByUserId(1l);
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
        }
        finally
        {
            sqlSession.close();
        }
    }
    
    @Test
    public void selectRolesByUserId2()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesByUserId2(1l);
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
            list.forEach(sysRole -> System.out.println(sysRole.getUser().getUserName()));
        }
        finally
        {
            sqlSession.close();
        }
    }
}
