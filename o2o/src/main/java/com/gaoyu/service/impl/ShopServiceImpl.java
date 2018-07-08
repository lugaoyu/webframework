package com.gaoyu.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoyu.dao.ShopDao;
import com.gaoyu.dto.ShopExecution;
import com.gaoyu.entity.Shop;
import com.gaoyu.enums.ShopStateEnum;
import com.gaoyu.exceptions.ShopOperationException;
import com.gaoyu.service.ShopService;
import com.gaoyu.util.ImageUtil;
import com.gaoyu.util.PathUtil;

/**
 * 
 * ClassName: ShopServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 下午3:04:40 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Service
public class ShopServiceImpl implements ShopService
{
        @Autowired
        private ShopDao shopDao;
        
        @Transactional
        @Override
        public ShopExecution addShop(Shop shop, File shopImg)
        {
                // 空值判断
                if (shop == null)
                {
                        return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
                }
                try
                {
                        // 给店铺信息赋初始值
                        shop.setEnableStatus(0);
                        shop.setCreateTime(new Date());
                        shop.setLastEditTime(new Date());
                        // 添加店铺信息
                        int effectedNum = shopDao.insertShop(shop);
                        if (effectedNum <= 0)
                        {
                                throw new ShopOperationException("店铺创建失败");
                        }
                        else
                        {
                                if (shopImg != null)
                                {
                                        // 存储图片
                                        try
                                        {
                                                addShopImg(shop, shopImg);
                                        }
                                        catch (Exception e)
                                        {
                                                // TODO: handle exception
                                                throw new ShopOperationException(
                                                                "addShopImg error"
                                                                                + e.getMessage());
                                        }
                                        // 更新店铺的图片地址
                                        effectedNum = shopDao.updateShop(shop);
                                        if (effectedNum <= 0)
                                        {
                                                throw new ShopOperationException(
                                                                "更新图片地址失败");
                                        }
                                }
                        }
                }
                catch (Exception e)
                {
                        // TODO: handle exception
                        try
                        {
                                throw new ShopOperationException(
                                                "addShop error:"
                                                                + e.getMessage());
                        }
                        catch (ShopOperationException e1)
                        {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                        }
                }
                return new ShopExecution(ShopStateEnum.CHECK, shop);
        }
        
        private void addShopImg(Shop shop, File shopImg)
        {
                // 获取shop图片目录的相对值路径
                String dest = PathUtil.getShopImagePath(shop.getShopId());
                String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
                shop.setShopImg(shopImgAddr);
        }
        
}
