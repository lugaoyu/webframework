package com.gaoyu.concurrent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gaoyu.example.threadLocal.RequestHolder;


public class HttpInterceptor extends HandlerInterceptorAdapter
{
        private static final Logger LOG =
                LoggerFactory.getLogger(HttpInterceptor.class);
        
        @Override
        public boolean preHandle(HttpServletRequest request,
                        HttpServletResponse response, Object handler)
                throws Exception
        {
                LOG.info("preHandle");
                return true;
        }
        
        @Override
        public void afterCompletion(HttpServletRequest request,
                        HttpServletResponse response, Object handler,
                        Exception ex)
                throws Exception
        {
                RequestHolder.remove();
                LOG.info("afterCompletion");
                return;
        }
        
}
