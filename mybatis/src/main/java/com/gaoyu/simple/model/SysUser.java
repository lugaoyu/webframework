package com.gaoyu.simple.model;

import java.util.Date;

/**
 * 
 * ClassName: SysUser <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年4月2日 上午10:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class SysUser
{
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserPassword()
    {
        return userPassword;
    }
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    public String getUserEmail()
    {
        return userEmail;
    }
    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }
    public String getUserInfo()
    {
        return userInfo;
    }
    public void setUserInfo(String userInfo)
    {
        this.userInfo = userInfo;
    }
    public byte[] getHeadImg()
    {
        return headImg;
    }
    public void setHeadImg(byte[] headImg)
    {
        this.headImg = headImg;
    }
    public Date getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
