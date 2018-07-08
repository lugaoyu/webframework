package com.gaoyu.concurrent;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.example.threadLocal.RequestHolder;

public class HttpFilter implements Filter
{
        private static final Logger LOG = LoggerFactory.getLogger(HttpFilter.class);

        @Override
        public void init(FilterConfig filterConfig)
                throws ServletException
        {
                
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                        FilterChain chain)
                throws IOException, ServletException
        {
                LOG.info("doFilter begin");
                HttpServletRequest request2  = (HttpServletRequest) request;
                LOG.info("do filter,{},{}",Thread.currentThread().getId(),request2.getServletPath());
                RequestHolder.add(Thread.currentThread().getId());
                chain.doFilter(request, response);
                LOG.info("doFilter end");
        }

        @Override
        public void destroy()
        {
                
        }
        
}
