package com.huawei.service;

import java.util.List;

import org.smart4j.framework.annotation.Autowired;
import org.smart4j.framework.annotation.Service;

import com.huawei.dao.CarrierDao;
import com.huawei.daobean.CarrierDaoBean;

/**
 * 承运商业务操作
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-09-22
 */
@Service
public class CarrierService {
	@Autowired
	private CarrierDao carrierDao;
	
	public List<CarrierDaoBean> queryCarrierServiceList(){
		List<CarrierDaoBean> carrierList = carrierDao.queryCarrierList();
		return carrierList;
	}
}
