package com.gaoyu.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoyu.miaosha.domain.User;
import com.gaoyu.miaosha.redis.RedisService;
import com.gaoyu.miaosha.redis.UserKey;
import com.gaoyu.miaosha.result.Result;
import com.gaoyu.miaosha.service.UserService;

/**
 * 
 * ClassName: SampleController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:52:39 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/demo")
public class SampleController
{
        @Autowired
        UserService userService;
        
        @Autowired
        RedisService redisService;
        
        @RequestMapping("/db/get")
        @ResponseBody
        public Result<User> dbGet()
        {
                User user = userService.getById(1);
                return Result.success(user);
        }
        
        @RequestMapping("/db/tx")
        @ResponseBody
        public Result<Boolean> tx()
        {
                userService.tx();
                return Result.success(true);
        }
        
        @RequestMapping("redis/get")
        @ResponseBody
        public Result<String> redisGet()
        {
                String value = redisService.getValueByKey(UserKey.getByName,"key1", String.class);
                return Result.success(value);
        }
        
        @RequestMapping("redis/set")
        @ResponseBody
        public Result<Boolean> redisSet()
        {
                boolean value = redisService.setValueUseKey(UserKey.getById,"key6", "gaoyu");
                return Result.success(value);
        }
        
        @RequestMapping("/redis/getUser")
        @ResponseBody
        public Result<User> redisGetUser()
        {
                User user = redisService.getValueByKey(UserKey.getById,"user1", User.class);
                return Result.success(user);
        }
        
        @RequestMapping("/redis/setUser")
        @ResponseBody
        public Result<Boolean> redisSetUser()
        {
                User user = new User();
                user.setId(10);
                user.setName("gaoyu");
                boolean result = redisService.setValueUseKey(UserKey.getById,"user1",user);
                return Result.success(result);
        }
}
