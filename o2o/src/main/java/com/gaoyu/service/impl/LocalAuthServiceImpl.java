package com.gaoyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoyu.dao.LocalAuthDao;
import com.gaoyu.dao.PersonInfoDao;
import com.gaoyu.entity.LocalAuth;
import com.gaoyu.service.LocalAuthService;


@Service
public class LocalAuthServiceImpl implements LocalAuthService
{
        
        @Autowired
        private LocalAuthDao localAuthDao;
        
        @Autowired
        private PersonInfoDao personInfoDao;
        
        @Override
        public LocalAuth getLocalAuthByUserNameAndPwd(String userName,String password)
        {
                return localAuthDao.queryLocalByUserNameAndPwd(userName,password);
        }
        
}
