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
        System.out.println("IndexController begin...");
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("now", new Date());
        System.out.println("IndexController end...");
        return mv;
    }
}   
