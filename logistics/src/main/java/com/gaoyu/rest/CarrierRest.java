package com.gaoyu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoyu.restbean.CarrierRestBean;
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
	    
	    @RequestMapping(value="/queryCarrierList", method=RequestMethod.POST)
	    @ResponseBody
	    public String queryCarrierList(){ 
	        System.out.println("xxx");
	    	return null;
	    }
}
