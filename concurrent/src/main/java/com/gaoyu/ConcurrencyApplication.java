package com.gaoyu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gaoyu.concurrent.HttpFilter;
import com.gaoyu.concurrent.HttpInterceptor;

/**
 * 并发编程
 * ClassName: ConcurrencyApplication <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月25日 下午9:40:24 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurerAdapter
{
        private static final Logger LOG = LoggerFactory.getLogger(ConcurrencyApplication.class);
        
        public static void main(String[] args)
        {
                SpringApplication.run(ConcurrencyApplication.class, args);
        }
        
        @Bean
        public FilterRegistrationBean httpFilter()
        {
                LOG.info("httpFilter begin");
                FilterRegistrationBean registrationBean = new FilterRegistrationBean();
                registrationBean.setFilter(new HttpFilter());
                registrationBean.addUrlPatterns("/threadLocal/*");
                LOG.info("httpFilter end");
                return registrationBean;
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry)
        {
                LOG.info("addInterceptors begin");
                registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
                LOG.info("addInterceptors end");
        }
        
}
