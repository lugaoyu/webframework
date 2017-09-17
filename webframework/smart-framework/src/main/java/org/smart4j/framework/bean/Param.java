package org.smart4j.framework.bean;

import java.util.Map;

import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.CollectionUtil;

/**
 * 请求参数对象
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-08
 */
public class Param {
	private Map<String,Object> paramMap;
	public Param(Map<String,Object> paramMap){
		this.paramMap = paramMap;
	}
	
	/**
	 * 根据参数名(类型)获取long型参数值
	 * @param name
	 * @return
	 */
	public long getLong(String name){
		return CastUtil.castLong(paramMap.get(name));
	}
	
	/**
	 * 获取所有字段信息
	 * @return
	 */
	public Map<String,Object> getMap(){
		return paramMap;
	}
	
	/**
	 * 验证参数是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return CollectionUtil.isEmpty(paramMap);
	}
}
