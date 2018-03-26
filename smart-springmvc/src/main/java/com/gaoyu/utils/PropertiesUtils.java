/**
 * Project Name:smart-springmvc
 * File Name:PropertiesUtils.java
 * Package Name:com.gaoyu.utils
 * Date:2018年3月25日上午9:51:14
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**读取配置文件工具类
 * ClassName:PropertiesUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年3月25日 上午9:51:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class PropertiesUtils
{
        private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);
        /**
         * 读取配置文件信息
         * getProperties:(这里用一句话描述这个方法的作用). <br/>
         * TODO(这里描述这个方法适用条件 – 可选).<br/>
         * TODO(这里描述这个方法的执行流程 – 可选).<br/>
         * TODO(这里描述这个方法的使用方法 – 可选).<br/>
         * TODO(这里描述这个方法的注意事项 – 可选).<br/>
         *
         * @author gaoyu
         * @param fileName 文件名
         * @return Properties
         * @since JDK 1.7
         */
        public static Properties getProperties(String fileName)
        {
                Properties properties = null;
                InputStream is = null;
                try
                {
                        is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
                        if(null == is)
                        {
                            throw new FileNotFoundException(fileName + " file is not found");
                        }
                        properties = new Properties();
                        properties.load(is);
                }
                catch (Exception e)
                {
                        LOGGER.error("load propertites file failure",e);
                }
                finally
                {
                        try
                        {
                                is.close();
                        }
                        catch(IOException e)
                        {
                            LOGGER.error("close input stream failure",e);
                        }
                }
                return properties;
        }
}

