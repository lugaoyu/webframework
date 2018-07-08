package com.gaoyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyu.dao.AreaDao;
import com.gaoyu.entity.Area;
import com.gaoyu.service.AreaService;


@Service
public class AreaServiceImpl implements AreaService
{
        @Autowired
        public AreaDao areaDao;
        
        @Override
        public List<Area> getAreaList()
        {
                return areaDao.queryArea();
        }
        
}
