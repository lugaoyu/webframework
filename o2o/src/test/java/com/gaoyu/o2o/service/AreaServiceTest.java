package com.gaoyu.o2o.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaoyu.entity.Area;
import com.gaoyu.o2o.dao.BaseTest;
import com.gaoyu.service.AreaService;

/**
 * 
 * ClassName: AreaServiceTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 上午10:50:59 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class AreaServiceTest extends BaseTest
{
        
        @Autowired
        private AreaService areaService;
        
        @Test
        public void testGetAreaList()
        {
                List<Area> areaList = areaService.getAreaList();
                Assert.assertEquals("东苑", areaList.get(0).getAreaName());
        }
}
