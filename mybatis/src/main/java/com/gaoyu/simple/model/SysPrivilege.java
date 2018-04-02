package com.gaoyu.simple.model;

/**
 * 
 * ClassName: SysPrivilege <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class SysPrivilege
{
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getPrivilegeName()
    {
        return privilegeName;
    }
    public void setPrivilegeName(String privilegeName)
    {
        this.privilegeName = privilegeName;
    }
    public String getPrivilegeUrl()
    {
        return privilegeUrl;
    }
    public void setPrivilegeUrl(String privilegeUrl)
    {
        this.privilegeUrl = privilegeUrl;
    }
}
