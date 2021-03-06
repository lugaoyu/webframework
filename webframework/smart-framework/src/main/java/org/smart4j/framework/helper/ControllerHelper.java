package org.smart4j.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.CollectionUtil;

/**
 * 控制器助手类
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-08
 */
public final class ControllerHelper {
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
	/**
	 * 初始化请求与controller对应关系
	 */
	static{
		//获取所有的Controller
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if(CollectionUtil.isNotEmpty(controllerClassSet)){
			//遍历这些Controller类
			for(Class<?> controllerClass : controllerClassSet){
				//获取Controller类中的定义方法
				Method[] methods = controllerClass.getDeclaredMethods();
				//遍历这些Controller类中的方法
				for(Method method : methods){
					//判断当前方法是否带有Action注解
					if(method.isAnnotationPresent(Action.class)){
						//从Action注解中获取URL映射规则
						Action action = method.getAnnotation(Action.class);
						String mapping = action.value();
						//验证URL映射规则
						if(mapping.matches("\\w+:/\\w*")){
							String[] array = mapping.split(":");
							if(ArrayUtils.isNotEmpty(array) && array.length == 2){
								//获取请求方法与请求路径
								String requestMethod = array[0];
								String requestPath = array[1];
								Request request = new Request(requestMethod, requestPath);
								Handler handler = new Handler(controllerClass, method);
								//初始化Action Map
								ACTION_MAP.put(request,handler);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 获取Handler
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod,String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}
