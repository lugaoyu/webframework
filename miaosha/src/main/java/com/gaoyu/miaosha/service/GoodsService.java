package com.gaoyu.miaosha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyu.miaosha.dao.GoodsDao;
import com.gaoyu.miaosha.domain.MiaoshaGoods;
import com.gaoyu.miaosha.vo.GoodsVo;

/**
 * 
 * ClassName: GoodsService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月23日 下午8:56:26 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Service
public class GoodsService
{
        @Autowired
        GoodsDao goodsDao;
        
        public List<GoodsVo> goodsList()
        {
                return goodsDao.getById();
        }
        
        public GoodsVo getGoodsVoByGoodsId(long goodsId)
        {
                return goodsDao.getGoodsVoByGoodsId(goodsId);
        }
        
        public void reduceStock(GoodsVo goods) 
        {
                MiaoshaGoods g = new MiaoshaGoods();
                g.setGoodsId(goods.getId());
                goodsDao.reduceStock(g);
        }
}
