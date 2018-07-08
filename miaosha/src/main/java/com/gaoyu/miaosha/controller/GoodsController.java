package com.gaoyu.miaosha.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaoyu.miaosha.domain.MiaoshaUser;
import com.gaoyu.miaosha.service.GoodsService;
import com.gaoyu.miaosha.service.MiaoshaService;
import com.gaoyu.miaosha.vo.GoodsVo;

/**
 * 商品控制器
 * ClassName: GoodsController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:23:03 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/goods")
public class GoodsController
{
        private static Logger LOG = LoggerFactory.getLogger(GoodsController.class);
        
        @Autowired
        private MiaoshaService userService;
        
        @Autowired
        MiaoshaService miaoshaService;
        
        @Autowired
        GoodsService goodsService;
        
        @RequestMapping("/to_list")
        public String to_list( Model model, MiaoshaUser user)
        {
                LOG.info("begin /to_list");
                model.addAttribute("user", user);
                List<GoodsVo> goodsList = goodsService.goodsList();
                model.addAttribute("goodsList", goodsList);
                return "goods_list";
        }
        
        @RequestMapping("/to_detail/{goodsId}")
        public String detail( Model model, MiaoshaUser user, @PathVariable("goodsId") long goodsId)
        {
                LOG.info("goodsId:"+goodsId);
                model.addAttribute("user", user);
                GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
                model.addAttribute("goods", goods);
                
                //
                long startAt = goods.getStartDate().getTime();
                long endAt = goods.getEndDate().getTime();
                long now = System.currentTimeMillis();
                
                int miaoshaStatus = 0;
                int remainSeconds = 0;
                if(now < startAt ) {//秒杀还没开始，倒计时
                        miaoshaStatus = 0;
                        remainSeconds = (int)((startAt - now )/1000);
                }else  if(now > endAt){//秒杀已经结束
                        miaoshaStatus = 2;
                        remainSeconds = -1;
                }else {//秒杀进行中
                        miaoshaStatus = 1;
                        remainSeconds = 0;
                }
                model.addAttribute("miaoshaStatus", miaoshaStatus);
                model.addAttribute("remainSeconds", remainSeconds);
                return "goods_detail";
        }
        
        
        @RequestMapping("/to_list1")
        public String to_list1(
                        Model model,
                        @CookieValue(value = MiaoshaService.COOK_NAME_TOKEN, required = false) String cookieToken,
                        @RequestParam(value = MiaoshaService.COOK_NAME_TOKEN, required = false) String paramToken,
                        HttpServletResponse response)
        {
                String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
                MiaoshaUser user = userService.getByToken(response,token);
                model.addAttribute("user", user);
                return "goods_list";
        }
}
