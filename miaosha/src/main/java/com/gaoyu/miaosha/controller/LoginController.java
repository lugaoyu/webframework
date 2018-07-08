package com.gaoyu.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoyu.miaosha.result.Result;
import com.gaoyu.miaosha.service.MiaoshaService;
import com.gaoyu.miaosha.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginController
{
        private static Logger LOG = LoggerFactory.getLogger(LoginController.class);
        
        @Autowired
        MiaoshaService miaoshaService;
        
        @RequestMapping("/to_login")
        public String toLogin()
        {
                return "login";
        }
        
        @RequestMapping("/do_login")
        @ResponseBody
        public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo)
        {
                LOG.info(loginVo.toString());
              /*  String passInput = loginVo.getPassword();
                String mobile = loginVo.getMobile();*/
               /* if(StringUtils.isEmpty(passInput))
                {
                        return Result.error(CodeMsg.PASSWORD_EMPTY);
                }
                if(StringUtils.isEmpty(mobile))
                {
                        return Result.error(CodeMsg.MOBILE_EMPTY);
                }
                if(!ValidatorUtil.isMobile(mobile))
                {
                        return Result.error(CodeMsg.MOBILE_ERROR);
                }*/
                //登录
                miaoshaService.login(response,loginVo);
               /* if(cm.getCode() == 0)
                {
                        LOG.info("success");
                        return Result.success(true);
                }
                else
                {
                        LOG.error("error");
                        return Result.error(cm);
                }*/
                return Result.success(true);
        }
}
