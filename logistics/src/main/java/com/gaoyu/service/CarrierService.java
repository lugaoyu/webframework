package com.gaoyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyu.dao.CarrierDao;
import com.gaoyu.daobean.CarrierDaoBean;

/**
 * 承运商业务操作
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-09-22
 */
@Service
public class CarrierService {
	
	private CarrierDao carrierDao;
	
	public List<CarrierDaoBean> queryCarrierServiceList(){
		List<CarrierDaoBean> carrierList = carrierDao.queryCarrierList();
		return carrierList;
	}
}
