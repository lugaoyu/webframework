package com.gaoyu.o2o.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaoyu.dao.ShopDao;
import com.gaoyu.entity.Area;
import com.gaoyu.entity.PersonInfo;
import com.gaoyu.entity.Shop;
import com.gaoyu.entity.ShopCategory;

/**
 * 
 * ClassName: ShopDaoTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 上午10:50:45 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class ShopDaoTest extends BaseTest
{
        @Autowired
        public ShopDao shopDao;
        
        @Test
        @Ignore
        public void insertShop()
        {
                Shop shop = new Shop();
                PersonInfo owner = new PersonInfo();
                Area area = new Area();
                ShopCategory shopCategory = new ShopCategory();
                owner.setUserId(1L);
                area.setAreaId(2);
                shopCategory.setShopCategoryId(1L);
                shop.setOwner(owner);
                shop.setArea(area);
                shop.setShopCategory(shopCategory);
                shop.setShopName("测试的店铺");
                shop.setShopDesc("test");
                shop.setShopAddr("test");
                shop.setPhone("test");
                shop.setShopImg("test");
                shop.setCreateTime(new Date());
                shop.setEnableStatus(1);
                shop.setAdvice("审核中");
                int effectedNum = shopDao.insertShop(shop);
                int id = shopDao.insertShop(shop);
                Assert.assertEquals(1, effectedNum);
                System.out.println(id);
                System.out.println(shop.getShopId());
        }
        
        @Test
        public void updateShop()
        {
                Shop shop = new Shop();
                shop.setShopId(1L);
                shop.setShopDesc("测试描述gaoyu");
                shop.setShopAddr("测试地址gaoyu");
                int effectedNum = shopDao.updateShop(shop);
                Assert.assertEquals(1, effectedNum);
        }
}
