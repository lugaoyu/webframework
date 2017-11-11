package com.lwx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.lwx.service.HelloService;

/**
 * 控制器
 * @author Administrator
 *  2017-11-11
 */
public class HelloController extends AbstractController {
	private HelloService helloService;
	private String viewName;
	
	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("开始处理请求");
		ModelAndView mav = new ModelAndView(getViewName());
		String result = helloService.hello();
		mav.addObject("hello", result);
		System.out.println("请求处理结束");
		return mav;
	}

}
