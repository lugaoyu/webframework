package com.gaoyu.service;

import com.gaoyu.intf.HelloService;

/**
 * date: 2018年7月7日 下午1:42:52 <br/>
 * @author gaoyu
 */
public class HelloServiceImpl implements HelloService
{
        public String sayHi(String name)
        {
                return "Hi, " + name;
        }
}
