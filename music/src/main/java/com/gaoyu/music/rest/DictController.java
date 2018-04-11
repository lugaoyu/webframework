package com.gaoyu.music.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gaoyu.music.daobean.SysDict;
import com.gaoyu.music.service.DictService;

@Controller
@RequestMapping("/dicts")
public class DictController
{
    @Autowired
    private DictService dictService;
    
    @RequestMapping
    public ModelAndView dicts(SysDict sysDict,Integer offset,Integer limit)
    {
        ModelAndView modelAndView = new ModelAndView("dicts");
        List<SysDict> dicts = dictService.findBySysDict(sysDict, offset, limit);
        modelAndView.addObject("dicts", dicts);
        return modelAndView;
    }
    
    @RequestMapping(value="add", method=RequestMethod.GET)
    public ModelAndView add(Long id)
    {
        ModelAndView modelAndView = new ModelAndView("dicts_add");
        SysDict sysDict;
        if(id == null)
        {
            sysDict = new SysDict();
        }
        else
        {
            sysDict = dictService.findById(id);
        }
        modelAndView.addObject("model", sysDict);
        return modelAndView;
    }
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public ModelAndView add(SysDict sysDict)
    {
        ModelAndView modelAndView = new ModelAndView();
        try
        {
            dictService.saveOrUpdate(sysDict);
            modelAndView.setViewName("redirect:/dicts");
        }
        catch (Exception e)
        {
            modelAndView.setViewName("dicts_add");
            modelAndView.addObject("msg",e.getMessage());
            modelAndView.addObject("model", sysDict);
        }
        return modelAndView;
    }
    
    @RequestMapping(value="delete", method=RequestMethod.POST)
    @ResponseBody
    public ModelMap delete(@RequestParam Long id)
    {
        ModelMap modelMap = new ModelMap();
        try
        {
            boolean success = dictService.deleteById(id);
            modelMap.put("success", success);
        }
        catch (Exception e)
        {
            modelMap.put("success", false);
            modelMap.put("msg", e.getMessage());
        }
        return modelMap;
    }
    
}
