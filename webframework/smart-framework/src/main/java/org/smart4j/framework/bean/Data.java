package org.smart4j.framework.bean;

/**
 * 返回数据对象
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-08
 */
public class Data {
	/**
	 * 模型数据
	 */
	private Object model;
	
	public Data(Object model){
		this.model = model;
	}
	
	public Object getModel(){
		return model;
	}
}
