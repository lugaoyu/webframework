package com.gaoyu.o2o.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaoyu.dao.AreaDao;
import com.gaoyu.entity.Area;


/**
 * 
 * @author gaoyu
 *
 */
public class AreaDaoTest extends BaseTest
{
        @Autowired
        AreaDao areaDao;
        
        @Test
        public void testQueryArea()
        {
                List<Area> areaList = areaDao.queryArea();
                Assert.assertEquals(4, areaList.size());
        }
}
