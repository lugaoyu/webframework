package com.gaoyu.entity;

import java.util.Date;

/**
 * 
 * ClassName: ShopCategory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 上午10:41:28 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class ShopCategory
{
        private Long shopCategoryId;
        
        private String shopCategoryName;
        
        private String shopCategoryDesc;
        
        private String shopCategoryImg;
        
        private Integer priority;//权重
        
        private Date createTime;
        
        private Date lastEditTime;
        
        private Long parentId; //上级ID
        
        public Long getShopCategoryId()
        {
                return shopCategoryId;
        }
        
        public void setShopCategoryId(Long shopCategoryId)
        {
                this.shopCategoryId = shopCategoryId;
        }
        
        public String getShopCategoryName()
        {
                return shopCategoryName;
        }
        
        public void setShopCategoryName(String shopCategoryName)
        {
                this.shopCategoryName = shopCategoryName;
        }
        
        public String getShopCategoryDesc()
        {
                return shopCategoryDesc;
        }
        
        public void setShopCategoryDesc(String shopCategoryDesc)
        {
                this.shopCategoryDesc = shopCategoryDesc;
        }
        
        public String getShopCategoryImg()
        {
                return shopCategoryImg;
        }
        
        public void setShopCategoryImg(String shopCategoryImg)
        {
                this.shopCategoryImg = shopCategoryImg;
        }
        
        public Integer getPriority()
        {
                return priority;
        }
        
        public void setPriority(Integer priority)
        {
                this.priority = priority;
        }
        
        public Date getCreateTime()
        {
                return createTime;
        }
        
        public void setCreateTime(Date createTime)
        {
                this.createTime = createTime;
        }
        
        public Date getLastEditTime()
        {
                return lastEditTime;
        }
        
        public void setLastEditTime(Date lastEditTime)
        {
                this.lastEditTime = lastEditTime;
        }
        
        public Long getParentId()
        {
                return parentId;
        }
        
        public void setParentId(Long parentId)
        {
                this.parentId = parentId;
        }
        
}
