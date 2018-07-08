package com.gaoyu.entity;

import java.util.Date;


/**
 * 
 * ClassName: WechatAuth <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 上午10:35:00 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
public class WechatAuth
{
        private Long wechatAuthId;
        
        private Long userId;
        
        private String openId;
        
        private Date createTime;
        
        private PersonInfo personInfo;
        
        public Long getWechatAuthId()
        {
                return wechatAuthId;
        }
        
        public void setWechatAuthId(Long wechatAuthId)
        {
                this.wechatAuthId = wechatAuthId;
        }
        
        public Long getUserId()
        {
                return userId;
        }
        
        public void setUserId(Long userId)
        {
                this.userId = userId;
        }
        
        public String getOpenId()
        {
                return openId;
        }
        
        public void setOpenId(String openId)
        {
                this.openId = openId;
        }
        
        public Date getCreateTime()
        {
                return createTime;
        }
        
        public void setCreateTime(Date createTime)
        {
                this.createTime = createTime;
        }
        
        public PersonInfo getPersonInfo()
        {
                return personInfo;
        }
        
        public void setPersonInfo(PersonInfo personInfo)
        {
                this.personInfo = personInfo;
        }
}
