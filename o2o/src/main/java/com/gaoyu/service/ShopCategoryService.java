package com.gaoyu.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gaoyu.entity.ShopCategory;


public interface ShopCategoryService
{
        /**
         * 查询指定某个店铺下的所有商品类别信息
         * 
         * @param long shopId
         * @return List<ProductCategory>
         * @throws JsonProcessingException
         * @throws IOException
         */
        List<ShopCategory> getFirstLevelShopCategoryList()
                throws IOException;
        
        /**
         * 
         * @param parentId
         * @return
         * @throws IOException
         */
        List<ShopCategory> getShopCategoryList(Long parentId)
                throws IOException;
        
        /**
         * 
         * @return
         * @throws IOException
         */
        List<ShopCategory> getAllSecondLevelShopCategory()
                throws IOException;
        
        /**
         * 
         * @param shopCategory
         * @return
         */
        ShopCategory getShopCategoryById(Long shopCategoryId);
        
}
