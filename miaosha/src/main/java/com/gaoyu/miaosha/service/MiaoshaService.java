package com.gaoyu.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyu.miaosha.dao.MiaoshaUserDao;
import com.gaoyu.miaosha.domain.MiaoshaUser;
import com.gaoyu.miaosha.domain.OrderInfo;
import com.gaoyu.miaosha.exception.GlobleException;
import com.gaoyu.miaosha.redis.MiaoshaUserKey;
import com.gaoyu.miaosha.redis.RedisService;
import com.gaoyu.miaosha.result.CodeMsg;
import com.gaoyu.miaosha.util.MD5Util;
import com.gaoyu.miaosha.util.UUIDUtil;
import com.gaoyu.miaosha.vo.GoodsVo;
import com.gaoyu.miaosha.vo.LoginVo;


@Service
public class MiaoshaService
{
        private static Logger LOG =
                LoggerFactory.getLogger(MiaoshaService.class);
        
        public static final String COOK_NAME_TOKEN = "token";
        
        private static final int seconds = 3600 * 24 * 2;
        
        @Autowired
        MiaoshaUserDao miaoshaUserDao;
        
        @Autowired
        RedisService redisService;
        
        @Autowired
        GoodsService goodsService;
        
        @Autowired
        OrderService orderService;
        
        public MiaoshaUser getById(String id)
        {
                return miaoshaUserDao.getById(id);
        }
        
        public boolean login(HttpServletResponse response, LoginVo loginVo)
        {
                if (loginVo == null)
                {
                        throw new GlobleException(CodeMsg.SERVER_ERROR);
                }
                String mobile = loginVo.getMobile();
                String password = loginVo.getPassword();
                MiaoshaUser miaoshaUser = getById(mobile);
                if (miaoshaUser == null)
                {
                        throw new GlobleException(CodeMsg.MOBILE_NOT_EXIST);
                }
                // 验证密码
                String dbPass = miaoshaUser.getPassword();
                String saltDB = miaoshaUser.getSalt();
                String calcPass = MD5Util.formPassToDBPass(password, saltDB);
                if (!calcPass.equals(dbPass))
                {
                        throw new GlobleException(CodeMsg.PASSWORD_ERROR);
                }
                // 设置cookie
                String token = UUIDUtil.getUUID();
                LOG.info(token);
                addCookie(response, miaoshaUser, token);
                
                return true;
        }
        
        private void addCookie(HttpServletResponse response,
                        MiaoshaUser miaoshaUser, String token)
        {
                Cookie cookie = new Cookie(COOK_NAME_TOKEN, token);
                cookie.setMaxAge(seconds);
                cookie.setPath("/");
                response.addCookie(cookie);
                redisService.setValueUseKey(MiaoshaUserKey.token,
                                token,
                                miaoshaUser);
        }
        
        public MiaoshaUser getByToken(HttpServletResponse response, String token)
        {
                if (StringUtils.isEmpty(token))
                {
                        return null;
                }
                MiaoshaUser user =
                        redisService.getValueByKey(MiaoshaUserKey.token,
                                        token,
                                        MiaoshaUser.class);
                if (user != null)
                {
                        addCookie(response, user, token);
                }
                return user;
        }

        public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods)
        {
              //减库存 下订单 写入秒杀订单
                goodsService.reduceStock(goods);
                //order_info maiosha_order
                return orderService.createOrder(user, goods);
        }
}
