package com.gaoyu.service;

import com.gaoyu.entity.LocalAuth;


public interface LocalAuthService
{
        /**
         * 
         * @param userName
         * @return
         */
        LocalAuth getLocalAuthByUserNameAndPwd(String userName, String password);
        
}
