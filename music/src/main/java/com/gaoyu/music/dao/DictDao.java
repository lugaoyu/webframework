package com.gaoyu.music.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.gaoyu.music.daobean.SysDict;

public interface DictDao
{
    SysDict selectByPrimaryKey(Long id);
    
    List<SysDict> selectBySysDict(SysDict sysDict,RowBounds rowBounds);
    
    int insert(SysDict sysDict);
    
    int updateById(SysDict sysDict);
    
    int deleteById(Long id);
}
