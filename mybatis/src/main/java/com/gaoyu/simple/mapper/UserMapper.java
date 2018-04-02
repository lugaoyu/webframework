package com.gaoyu.simple.mapper;

import java.util.List;

import com.gaoyu.simple.model.SysRole;
import com.gaoyu.simple.model.SysUser;

/**
 * 
 * ClassName: UserMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public interface UserMapper
{
    /**
     * 
     * @param id
     * @return
     */
    SysUser selectById(Long id);
    
    /**
     * 
     * @return
     */
    List<SysUser> selectAll();
    
    /**
     * 
     * @return
     */
    List<SysUser> selectAll2();
    
    /**
     * 
     * @param id
     * @return
     */
    List<SysRole> selectRolesByUserId(Long id);
    
    /**
     * 
     * @param id
     * @return
     */
    List<SysRole> selectRolesByUserId2(Long id);
}
