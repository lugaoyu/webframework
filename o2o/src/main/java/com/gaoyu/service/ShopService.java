package com.gaoyu.service;

import java.io.File;

import com.gaoyu.dto.ShopExecution;
import com.gaoyu.entity.Shop;


/**
 * 
 * ClassName: ShopService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 下午3:04:03 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
public interface ShopService
{
        ShopExecution addShop(Shop shop, File shopImg);
}
