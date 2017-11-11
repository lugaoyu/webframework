package com.lwx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Administrator
 * 2017-11-11
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        System.out.println("Servlet被初始化的時候會被調用");
    }
    
    @Override
    public void init()
    {
    	//某Servlet的初始化参数需要通过ServletConfig对象获取到
    	ServletConfig servletConfig = getServletConfig();
    	String init_paramValue = servletConfig.getInitParameter("HelloServlet-init-param");
    	System.out.println("Servlet被創建時,會自動調用init方法,可再此獲取web配置中的參數值: "+init_paramValue);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter pw = response.getWriter();
			pw.write("Hello client,My name is Response");
			pw.flush();
			pw.close();
	}

}
