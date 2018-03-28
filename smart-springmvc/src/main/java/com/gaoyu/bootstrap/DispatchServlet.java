package com.gaoyu.bootstrap;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gaoyu.bean.Handler;
import com.gaoyu.bean.Params;
import com.gaoyu.bean.RequestBean;
import com.gaoyu.helper.BeanHelper;
import com.gaoyu.helper.ControllerHelper;
import com.gaoyu.utils.ReflectionUtils;

/**DispatchServlet请求分发工具类
 * ClassName:DispatchServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月29日 上午10:07:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class DispatchServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private Enumeration<String> parameterNames;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String requestPath = request.getPathInfo();
        String requestMethod = request.getMethod().toLowerCase();
        RequestBean requestBean = new RequestBean(requestPath,requestMethod);
        Handler handler = ControllerHelper.getHandler(requestBean);
        parameterNames = request.getParameterNames();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        while (parameterNames.hasMoreElements())
        {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            paramMap.put(paramName, paramValue);
        }
        Params params = new Params(paramMap);
        Class<?> controllerClass = handler.getControllerClass();
        Method method = handler.getActionMethod();
        Object controllerObject = BeanHelper.getBean(controllerClass);
        Object result = ReflectionUtils.invokeMethod(controllerObject, method, params);
        response.setContentType("application/json");;
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        String json = JSON.toJSONString(result);  
        pw.write(json);
        pw.flush();
        pw.close();
    }
}
