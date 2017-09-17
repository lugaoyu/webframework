package com.huawei.rest;

import java.util.List;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Autowired;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.bean.Data;

import com.huawei.daobean.CarrierDaoBean;
import com.huawei.service.CarrierService;

/**
 * Carrier Controller
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-09-22
 */
@Controller
public class CarrierRest {
	    @Autowired
		private CarrierService carrierService;
	    
	    @Action(value="POST:/queryCarrierList")
	    public Data queryCarrierList(){
	    	List<CarrierDaoBean>  carrierList = carrierService.queryCarrierServiceList();
	    	Data data = new Data(carrierList);
	    	return data;
	    }
}
