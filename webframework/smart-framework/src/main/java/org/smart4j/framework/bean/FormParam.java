package org.smart4j.framework.bean;

/**
 * 封装表单参数
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-22
 */
public class FormParam {
	private String fieldName;
	private Object fieldValue;
	public FormParam(String fieldName, Object fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
}
