package com.gaoyu.miaosha.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.gaoyu.miaosha.domain.MiaoshaUser;
import com.gaoyu.miaosha.service.MiaoshaService;


/**
 * 自定义参数解析器 ClassName: UserArgumentResolver <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:22:33 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver
{
        @Autowired
        MiaoshaService miaoshaService;
        
        @Override
        public boolean supportsParameter(MethodParameter parameter)
        {
                Class<?> clazz = parameter.getParameterType();
                return clazz == MiaoshaUser.class;
        }
        
        @Override
        public Object resolveArgument(MethodParameter parameter,
                        ModelAndViewContainer mavContainer,
                        NativeWebRequest webRequest,
                        WebDataBinderFactory binderFactory)
                throws Exception
        {
                HttpServletRequest request =
                        webRequest.getNativeRequest(HttpServletRequest.class);
                HttpServletResponse response =
                        webRequest.getNativeResponse(HttpServletResponse.class);
                String paramToken =
                        request.getParameter(MiaoshaService.COOK_NAME_TOKEN);
                String cookieToken =
                        getCookieValue(request, MiaoshaService.COOK_NAME_TOKEN);
                if (StringUtils.isEmpty(cookieToken)
                                && StringUtils.isEmpty(paramToken))
                {
                        return null;
                }
                String token =
                        StringUtils.isEmpty(paramToken) ? cookieToken
                                        : paramToken;
                return miaoshaService.getByToken(response, token);
        }
        
        private String getCookieValue(HttpServletRequest request,
                        String cookNameToken)
        {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies)
                {
                        if (cookie.getName().equals(cookNameToken))
                        {
                                return cookie.getValue();
                        }
                }
                return null;
        }
        
}
