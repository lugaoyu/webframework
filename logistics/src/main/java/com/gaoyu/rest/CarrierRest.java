package com.gaoyu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.gaoyu.service.CarrierService;

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
	    
	    public Object queryCarrierList(){
	    	return null;
	    }
}
