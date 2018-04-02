package com.gaoyu.simple.model;

/**
 * 
 * ClassName: SysUserRole <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class SysUserRole
{
    private Long userId;
    private Long roleId;
    public Long getUserId()
    {
        return userId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
    public Long getRoleId()
    {
        return roleId;
    }
    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }
}
