package com.gaoyu.o2o.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaoyu.dao.ShopCategoryDao;
import com.gaoyu.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest
{
        @Autowired
        private ShopCategoryDao shopCategoryDao;
        
        @Test
        public void testQueryShopCategory()
        {
                List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
                Assert.assertEquals(2, shopCategories.size());
        }
}
