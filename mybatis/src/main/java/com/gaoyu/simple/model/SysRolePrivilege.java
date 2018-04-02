package com.gaoyu.simple.model;

/**
 * 
 * ClassName: SysRolePrivilege <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class SysRolePrivilege
{
    private Long role_id;
    private Long privilege_id;
    public Long getRole_id()
    {
        return role_id;
    }
    public void setRole_id(Long role_id)
    {
        this.role_id = role_id;
    }
    public Long getPrivilege_id()
    {
        return privilege_id;
    }
    public void setPrivilege_id(Long privilege_id)
    {
        this.privilege_id = privilege_id;
    }
}
