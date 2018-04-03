package com.gaoyu.simple.mapper;

import java.util.Date;
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
    
    @Test
    public void insert()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sUser = new SysUser();
            sUser.setUserName ("test1");
            sUser.setUserPassword ("123456");
            sUser.setUserEmail("test@mybatis.tk");
            sUser.setUserInfo("test info");
            sUser.setHeadImg(new byte[]{1,2,3});
            sUser.setCreateTime(new Date());
            int result = userMapper.insert(sUser);
            Assert.assertEquals(1, result);
        }
        finally
        {
            //为了不影响后续其他测试，这里选择回滚
            sqlSession.rollback();
            //sqlSession.commit();//手动提交
            sqlSession.close();
        }
    }
    
    @Test
    public void insert2()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sUser = new SysUser();
            sUser.setUserName ("test1");
            sUser.setUserPassword ("123456");
            sUser.setUserEmail("test@mybatis.tk");
            sUser.setUserInfo("test info");
            sUser.setHeadImg(new byte[]{1,2,3});
            sUser.setCreateTime(new Date());
            int result = userMapper.insert2(sUser);
            Assert.assertEquals(1, result);
            System.err.println(sUser.getId());
        }
        finally
        {
            //sqlSession.commit();
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void insert3()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sUser = new SysUser();
            sUser.setUserName ("test1");
            sUser.setUserPassword ("123456");
            sUser.setUserEmail("test@mybatis.tk");
            sUser.setUserInfo("test info");
            sUser.setHeadImg(new byte[]{1,2,3});
            sUser.setCreateTime(new Date());
            int result = userMapper.insert3(sUser);
            Assert.assertEquals(1, result);
            System.err.println(sUser.getId());
        }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void updateById()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            Assert.assertEquals("admin", sysUser.getUserName());
            sysUser.setUserName("admin_test");
            sysUser.setUserEmail("test@mybatis.tk");
            int result = userMapper.updateById(sysUser);
            Assert.assertEquals(1, result);
            sysUser = userMapper.selectById(1L);
            Assert.assertEquals("admin_test", sysUser.getUserName());
        }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void deleteById()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            Assert.assertNotNull(sysUser);
            //调用方法删除
            Assert.assertEquals(1, userMapper.deleteById(sysUser));
            Assert.assertNull(userMapper.selectById(1L));
        }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void selectRolesByUserIdAndRoleEnabled()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            list.forEach(sysrole -> System.out.println(sysrole.getId()+":"+sysrole.getCreate_by()+sysrole.getCreate_time().toString()));
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
        }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
