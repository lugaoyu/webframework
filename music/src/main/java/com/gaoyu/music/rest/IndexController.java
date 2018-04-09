package com.gaoyu.music.rest;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController
{
    @RequestMapping(value={"","/index"})
    public ModelAndView dicts()
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("now", new Date());
        return mv;
    }
}   
