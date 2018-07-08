package com.gaoyu.o2o.service;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaoyu.dto.ShopExecution;
import com.gaoyu.entity.Area;
import com.gaoyu.entity.PersonInfo;
import com.gaoyu.entity.Shop;
import com.gaoyu.entity.ShopCategory;
import com.gaoyu.enums.ShopStateEnum;
import com.gaoyu.o2o.dao.BaseTest;
import com.gaoyu.service.ShopService;

/**
 * 
 * ClassName: ShopServiceTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 下午8:40:05 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class ShopServiceTest extends BaseTest
{
        @Autowired
        private ShopService shopService;
        
        @Test
        public void testAddShop()
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
                shop.setShopName("测试的店铺1");
                shop.setShopDesc("test1");
                shop.setShopAddr("test1");
                shop.setPhone("test1");
                shop.setShopImg("test1");
                shop.setCreateTime(new Date());
                shop.setEnableStatus(ShopStateEnum.CHECK.getState());
                shop.setAdvice("审核中");
                File shopImg = new File("D:\\image\\timg.jpg");
                ShopExecution se = shopService.addShop(shop, shopImg);
                Assert.assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
        }
        
}
