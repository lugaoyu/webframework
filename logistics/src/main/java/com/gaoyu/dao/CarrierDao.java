package com.gaoyu.dao;

import java.util.List;

import com.gaoyu.daobean.CarrierDaoBean;

/**Droid Serif字体
 * 承运商数据库操作
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-09-22
 */
public interface CarrierDao {
		/**
		 * 新增承运商
		 * @param carrierDaoBean
		 */
		void insertCarrier(CarrierDaoBean carrierDaoBean);
		
		/**
		 * 查询承运商列表
		 * @return
		 */
		List<CarrierDaoBean> queryCarrierList();
		
		/**
		 * 根据条件查询承运商
		 * @param carrierDaoBean
		 * @return
		 */
		CarrierDaoBean queryCarrierByCondition(CarrierDaoBean carrierDaoBean);
		
		/**
		 * 根据条件删除承运商
		 * @param carrierDaoBean
		 */
		void deleteCarrierByCondition(CarrierDaoBean carrierDaoBean);
		
		/**
		 * 删除承运商列表
		 */
		void deleteCarrierList();
		
		/**
		 * 根据条件设置承运商的状态
		 * @param carrierDaoBean
		 */
		void setCarrierStatusByCondition(CarrierDaoBean carrierDaoBean);
}
