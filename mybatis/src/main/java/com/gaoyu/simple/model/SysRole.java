package com.gaoyu.simple.model;

import java.util.Date;

/**
 * 
 * ClassName: SysRole <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class SysRole
{
    private Long id;
    private String roleName;
    private Integer enabled;
    private Long create_by;
    private Date create_time;
    private SysUser user;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getRoleName()
    {
        return roleName;
    }
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    public Integer getEnabled()
    {
        return enabled;
    }
    public void setEnabled(Integer enabled)
    {
        this.enabled = enabled;
    }
    public Long getCreate_by()
    {
        return create_by;
    }
    public void setCreate_by(Long create_by)
    {
        this.create_by = create_by;
    }
    public Date getCreate_time()
    {
        return create_time;
    }
    public void setCreate_time(Date create_time)
    {
        this.create_time = create_time;
    }
    public SysUser getUser()
    {
        return user;
    }
    public void setUser(SysUser user)
    {
        this.user = user;
    }
}
