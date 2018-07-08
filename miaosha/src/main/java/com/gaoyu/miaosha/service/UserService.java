package com.gaoyu.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoyu.miaosha.dao.UserDao;
import com.gaoyu.miaosha.domain.User;

/**
 * 
 * ClassName: UserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:50:07 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Service
public class UserService
{
        @Autowired
        UserDao userDao;
        
        public User getById(int id)
        {
                return userDao.getById(id);
        }
        
        @Transactional
        public boolean tx()
        {
                User u1 = new User();
                u1.setId(2);
                u1.setName("222");
                userDao.insert(u1);
                
                User u2 = new User();
                u2.setId(1);
                u2.setName("111");
                userDao.insert(u2);
                
                return true;
        }
}
