package com.gaoyu.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoyu.miaosha.result.CodeMsg;
import com.gaoyu.miaosha.result.Result;


/**
 * 
 * ClassName: DemoController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:52:31 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/demo")
public class DemoController
{
        @RequestMapping("/")
        @ResponseBody
        public String home()
        {
                return "hello world!";
        }
        
        @RequestMapping("/hello")
        @ResponseBody
        public Result<String> hello()
        {
                return Result.success("hello,gaoyu!");
        }
        
        @RequestMapping("/helloError")
        @ResponseBody
        public Result<String> helloError()
        {
                return Result.error(CodeMsg.SERVER_ERROR);
        }
        
        @RequestMapping("/thymeleaf")
        public String thymeleaf(Model modal)
        {
                modal.addAttribute("name", "gaoyu");
                return "hello";
        }
}
