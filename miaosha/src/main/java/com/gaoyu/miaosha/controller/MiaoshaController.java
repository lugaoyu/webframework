package com.gaoyu.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaoyu.miaosha.domain.MiaoshaOrder;
import com.gaoyu.miaosha.domain.MiaoshaUser;
import com.gaoyu.miaosha.domain.OrderInfo;
import com.gaoyu.miaosha.redis.RedisService;
import com.gaoyu.miaosha.result.CodeMsg;
import com.gaoyu.miaosha.service.GoodsService;
import com.gaoyu.miaosha.service.MiaoshaService;
import com.gaoyu.miaosha.service.OrderService;
import com.gaoyu.miaosha.vo.GoodsVo;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController
{
        @Autowired
        public MiaoshaService userService;
        
        @Autowired
        public RedisService redisService;
        
        @Autowired
        public GoodsService goodsService;
        
        @Autowired
        public OrderService orderService;
        
        @Autowired
        public MiaoshaService miaoshaService;
        
        @RequestMapping("/do_miaosha")
        public String list(Model model, MiaoshaUser user,
                        @RequestParam("goodsId") long goodsId)
        {
                model.addAttribute("user", user);
                if (user == null)
                {
                        return "login";
                }
                // 判断库存
                GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
                int stock = goods.getStockCount();
                if (stock <= 0)
                {
                        model.addAttribute("errmsg",
                                        CodeMsg.MIAO_SHA_OVER.getMsg());
                        return "miaosha_fail";
                }
                // 判断是否已经秒杀到了
                MiaoshaOrder order =
                        orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(),
                                        goodsId);
                if (order != null)
                {
                        model.addAttribute("errmsg",
                                        CodeMsg.REPEATE_MIAOSHA.getMsg());
                        return "miaosha_fail";
                }
                // 减库存 下订单 写入秒杀订单
                OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
                model.addAttribute("orderInfo", orderInfo);
                model.addAttribute("goods", goods);
                return "order_detail";
        }
}
