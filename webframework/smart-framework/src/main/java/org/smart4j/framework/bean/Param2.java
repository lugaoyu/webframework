/*package org.smart4j.framework.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.StringUtil;

*//**
 * 请求参数对象
 * 
 * @author lugaoyu
 * @since 1.0.1
 * @data 2017-08-23
 *//*
public class Param2 {
	private List<FormParam> formParamList;
	private List<FileParam> fileParamList;
	public Param2(List<FormParam> formParamList) {
		this.formParamList = formParamList;
	}
	public Param2(List<FormParam> formParamList, List<FileParam> fileParamList) {
		this.formParamList = formParamList;
		this.fileParamList = fileParamList;
	}
	
	*//**
	 * 获取请求参数映射
	 * @return
	 *//*
	 public Map<String,Object> getFieldMap(){
		 Map<String, Object> fieldMap = new HashMap<String, Object>();
		 if(CollectionUtil.isNotEmpty(formParamList)){
			 for(FormParam formParam : formParamList){
				 String fieldName = formParam.getFieldName();
				 Object fieldValue = formParam.getFieldValue();
				 if(fieldMap.containsKey(fieldName)){
					 fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
 				 }
				 fieldMap.put(fieldName, fieldValue);
			 }
		 }
		 return fieldMap;
	 }
	 
	 *//**
	  * 获取上传文件映射
	  * @return
	  *//*
	 public Map<String,List<FileParam>> getFileMap(){
		 Map<String,List<FileParam>> fileMap = new HashMap<String,List<FileParam>>();
		 if(CollectionUtil.isNotEmpty(fileParamList)){
			 for(FileParam fileParam : fileParamList){
				 String fieldName = fileParam.getFieldName();
				 List<FileParam> fileParamList;
				 if(fileMap.containsKey(fieldName)){
					 fileParamList = fileMap.get(fieldName);
				 }else{
					 fileParamList = new ArrayList<FileParam>();
				 }
				 fileParamList.add(fileParam);
				 fileMap.put(fieldName, fileParamList);
			 }
		 }
		 return fileMap;
	 }
	 
	 *//**
	  * 获取所有上传文件
	  * @param fieldName
	  * @return
	  *//*
	 public List<FileParam> getFileList(String fieldName){
		 return getFileMap().get(fieldName);
	 }
	 
	 *//**
	  * 获取唯一上传文件
	  * @param fieldName
	  * @return
	  *//*
	 public FileParam getFile(String fieldName){
		 List<FileParam> fileParamList = getFileList(fieldName);
		 if(CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1){
			 return fileParamList.get(0);
		}
		return null;
	 }
}
*/