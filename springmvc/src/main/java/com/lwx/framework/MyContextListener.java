package com.lwx.framework;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
			ServletContext sc = arg0.getServletContext();
			System.out.println("容器啓動時,自動調用該方法,可在該方法裏初始化Spring父容器");
			sc.setAttribute("setArrtibute: ", "設置參數");
			String contextConfigureLocation = sc.getInitParameter("contextConfigLocation");
			System.out.println("從web文件裏獲取到父容器的配置文件路徑: "+contextConfigureLocation);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
			System.out.println("容器關閉時,該再此方法裏關閉資源");
	}


}
