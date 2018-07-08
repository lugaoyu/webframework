package com.gaoyu.dao;

import com.gaoyu.entity.Shop;

/**
 * 
 * ClassName: ShopDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 下午2:16:44 <br/>
 *
 *  mybatis自动实现该接口下的方法实现类
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public interface ShopDao
{
        /**
         * 新增店铺
         * 
         * @param shop
         * @return
         */
        int insertShop(Shop shop);
        
        /**
         * 更新店铺
         * 
         * @param shop
         * @return
         */
        int updateShop(Shop shop);
        
}
