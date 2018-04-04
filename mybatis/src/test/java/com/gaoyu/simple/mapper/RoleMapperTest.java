package com.gaoyu.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.gaoyu.simple.model.SysRole;

public class RoleMapperTest extends BaseMapperTest
{
    @Test
    public void selectById()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
            System.out.println(role.getRoleName());
        }
        finally
        {
            sqlSession.close();
        }
    }
    
    @Test
    public void selectById2()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById2(1L);
            Assert.assertNotNull(sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());
        }
        finally
        {
            sqlSession.close();
        }
    }
    
    /*@Test
    public void selectAll()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> list = roleMapper.selectAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size()>0);
            Assert.assertNotNull(list.get(0).getRoleName());
        }
        finally
        {
            sqlSession.close();
        }
    }*/
    
    @Test
    public void insert()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            sysRole.setEnabled(1);
            sysRole.setRoleName("管理员");
            int result = roleMapper.insert(sysRole);
            System.err.println(result);
            Assert.assertEquals(1, result);
        }
        finally
        {   
            //sqlSession.commit();
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void insert2()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            sysRole.setEnabled(1);
            sysRole.setRoleName("管理员");
            int result = roleMapper.insert2(sysRole);
            Assert.assertEquals(1, result);
            System.err.println(sysRole.getId());
        }
        finally
        {
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
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            sysRole.setEnabled(1);
            sysRole.setRoleName("管理员");
            int result = roleMapper.insert3(sysRole);
            Assert.assertEquals(1, result);
            System.err.println(sysRole.getId());
        }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void update()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setId(2L);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            sysRole.setEnabled(1);
            sysRole.setRoleName("管理员");
            int result = roleMapper.updateById(sysRole);
            Assert.assertEquals(1, result);
         }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void delete()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int result = roleMapper.deleteById(2L);
            Assert.assertEquals(1, result);
        }
        finally
        {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
