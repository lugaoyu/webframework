package com.gaoyu.core;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig
{
    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
    
    static
    {
        servletMappingList.add(new ServletMapping("helloWorld","/world", "com.gaoyu.servlet.HelloWorldServlet"));
    }
}
