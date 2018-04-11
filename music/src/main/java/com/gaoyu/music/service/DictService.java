package com.gaoyu.music.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyu.music.dao.DictDao;
import com.gaoyu.music.daobean.SysDict;

@Service
public class DictService
{
    @Autowired
    private DictDao dictDao;
    
    public SysDict findById(@NotNull Long id)
    {
        return dictDao.selectByPrimaryKey(id);
    }
    
    public List<SysDict> findBySysDict(SysDict sysDict,Integer offset,Integer limit)
    {
        RowBounds rowBounds = RowBounds.DEFAULT;
        if(offset != null && limit != null)
        {
            rowBounds = new RowBounds(offset,limit);
        }
        return dictDao.selectBySysDict(sysDict, rowBounds);
    }
    
    public boolean saveOrUpdate(SysDict sysDict)
    {
        if(sysDict.getId() == null)
        {
            return dictDao.insert(sysDict) == 1;
        }
        else
        {
            return dictDao.updateById(sysDict) == 1;
        }
    }
    
    public boolean deleteById(@NotNull Long id)
    {
        return dictDao.deleteById(id) == 1;
    }
}
